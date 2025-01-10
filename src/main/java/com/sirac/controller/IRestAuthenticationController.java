package com.sirac.controller;

import com.sirac.dto.AuthRequest;
import com.sirac.dto.DtoLoginUser;

public interface IRestAuthenticationController {

    public RootEntity<DtoLoginUser> register(AuthRequest input);
}
