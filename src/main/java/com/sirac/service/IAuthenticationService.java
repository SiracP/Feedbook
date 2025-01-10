package com.sirac.service;

import com.sirac.dto.AuthRequest;
import com.sirac.dto.DtoLoginUser;

public interface IAuthenticationService {

    public DtoLoginUser register(AuthRequest input);
}
