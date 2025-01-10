package com.sirac.controller.impl;

import com.sirac.controller.IRestAuthenticationController;
import com.sirac.controller.RestBaseController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.AuthRequest;
import com.sirac.dto.DtoLoginUser;
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
    public RootEntity<DtoLoginUser> register(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.register(input));
    }
}
