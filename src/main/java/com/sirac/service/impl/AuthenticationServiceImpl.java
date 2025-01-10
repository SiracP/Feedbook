package com.sirac.service.impl;

import com.sirac.dto.AuthRequest;
import com.sirac.dto.DtoLoginUser;
import com.sirac.model.LoginUser;
import com.sirac.repository.LoginUserRepository;
import com.sirac.service.IAuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private LoginUser createLoginUser(AuthRequest input){
        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(input.getUsername());
        loginUser.setCreateTime(new Date());
        loginUser.setUpdateTime(new Date());
        loginUser.setPassword(passwordEncoder.encode(input.getPassword()));

        return loginUser;
    }
    @Override
    public DtoLoginUser register(AuthRequest input) {
        DtoLoginUser dtoLoginUser = new DtoLoginUser();
        LoginUser savedLoginUser = loginUserRepository.save(createLoginUser(input));

        BeanUtils.copyProperties(savedLoginUser,dtoLoginUser);
        return dtoLoginUser;
    }
}
