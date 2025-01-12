package com.sirac.service.impl;

import com.sirac.dto.AuthRequest;
import com.sirac.dto.AuthResponse;
import com.sirac.dto.DtoUser;
import com.sirac.dto.RefreshTokenRequest;
import com.sirac.dto.dto_insert_update.DtoUserIU;
import com.sirac.exception.BaseException;
import com.sirac.exception.ErrorMessage;
import com.sirac.exception.MessageType;
import com.sirac.jwt.JWTService;
import com.sirac.model.RefreshToken;
import com.sirac.model.User;
import com.sirac.repository.RefreshTokenRepository;
import com.sirac.repository.UserRepository;
import com.sirac.service.IAuthenticationService;
import com.sirac.service.SavedToDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService, SavedToDto {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private User createUser(DtoUserIU input){
        User user = new User();
        user.setUsername(input.getUsername());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setNickname(input.getNickname());
        user.setFollowersCount(0L);
        user.setFollowingCount(0L);

        return user;
    }

    private RefreshToken createRefreshToken(User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreateTime(new Date());
        refreshToken.setUpdateTime(new Date());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public DtoUser register(DtoUserIU input) {
        User savedUser = userRepository.save(createUser(input));

        return savedToDtoUser(savedUser);
    }

    @Override
    public AuthResponse login(AuthRequest input) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(input.getUsername(),input.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            Optional<User> optionalUser = userRepository.findByUsername(input.getUsername());

            String accessToken = jwtService.generateToken(optionalUser.get());

            RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optionalUser.get()));

            return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken(),optionalUser.get());

        }catch (Exception ex) {
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID,ex.getMessage()));
        }
    }
    public boolean isRefreshTokenExpired(Date expireDate){
        return new Date().after(expireDate);
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest input) {
        Optional<RefreshToken> optionalRefreshToken = refreshTokenRepository.findByRefreshToken(input.getRefreshToken());

        if(optionalRefreshToken.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND,input.getRefreshToken()));
        }

        if(isRefreshTokenExpired(optionalRefreshToken.get().getExpireDate())){
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_IS_EXPIRED,input.getRefreshToken()));
        }

        User user = optionalRefreshToken.get().getUser();
        String accessToken = jwtService.generateToken(user);
        RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(user));

        return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken(),user);
    }
}
