package com.sirac.service;

import com.sirac.dto.AuthRequest;
import com.sirac.dto.AuthResponse;
import com.sirac.dto.DtoLoginUser;
import com.sirac.dto.RefreshTokenRequest;

public interface IAuthenticationService {

    public DtoLoginUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);

    public AuthResponse refreshToken(RefreshTokenRequest input);
}
