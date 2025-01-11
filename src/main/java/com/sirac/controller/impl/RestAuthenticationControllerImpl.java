package com.sirac.controller.impl;

import com.sirac.controller.IRestAuthenticationController;
import com.sirac.controller.RestBaseController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.AuthRequest;
import com.sirac.dto.AuthResponse;
import com.sirac.dto.DtoUser;
import com.sirac.dto.RefreshTokenRequest;
import com.sirac.dto.dto_insert_update.DtoUserIU;
import com.sirac.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody DtoUserIU input) {
        return ok(authenticationService.register(input));
    }

    @PostMapping("/login")
    @Override
    public RootEntity<AuthResponse> login(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.login(input));
    }

    @PostMapping("/refreshToken")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest input) {
        return ok(authenticationService.refreshToken(input));
    }
}
