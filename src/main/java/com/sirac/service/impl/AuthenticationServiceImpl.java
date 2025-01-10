package com.sirac.service.impl;

import com.sirac.dto.AuthRequest;
import com.sirac.dto.AuthResponse;
import com.sirac.dto.DtoLoginUser;
import com.sirac.dto.RefreshTokenRequest;
import com.sirac.exception.BaseException;
import com.sirac.exception.ErrorMessage;
import com.sirac.exception.MessageType;
import com.sirac.jwt.JWTService;
import com.sirac.model.LoginUser;
import com.sirac.model.RefreshToken;
import com.sirac.repository.LoginUserRepository;
import com.sirac.repository.RefreshTokenRepository;
import com.sirac.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private LoginUser createLoginUser(AuthRequest input){
        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(input.getUsername());
        loginUser.setCreateTime(new Date());
        loginUser.setUpdateTime(new Date());
        loginUser.setPassword(passwordEncoder.encode(input.getPassword()));

        return loginUser;
    }

    private RefreshToken createRefreshToken(LoginUser loginUser){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreateTime(new Date());
        refreshToken.setUpdateTime(new Date());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setLoginUser(loginUser);
        return refreshToken;
    }

    @Override
    public DtoLoginUser register(AuthRequest input) {
        DtoLoginUser dtoLoginUser = new DtoLoginUser();
        LoginUser savedLoginUser = loginUserRepository.save(createLoginUser(input));

        BeanUtils.copyProperties(savedLoginUser,dtoLoginUser);
        return dtoLoginUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest input) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(input.getUsername(),input.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            Optional<LoginUser> optionalLoginUser = loginUserRepository.findByUsername(input.getUsername());

            String accessToken = jwtService.generateToken(optionalLoginUser.get());

            RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optionalLoginUser.get()));

            return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());

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

        LoginUser loginUser = optionalRefreshToken.get().getLoginUser();
        String accessToken = jwtService.generateToken(loginUser);
        RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(loginUser));

        return new AuthResponse(accessToken,savedRefreshToken.getRefreshToken());
    }
}
