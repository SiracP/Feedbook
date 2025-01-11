package com.sirac.service;

import com.sirac.dto.AuthRequest;
import com.sirac.dto.AuthResponse;
import com.sirac.dto.DtoUser;
import com.sirac.dto.RefreshTokenRequest;
import com.sirac.dto.dto_insert_update.DtoUserIU;

public interface IAuthenticationService {

    public DtoUser register(DtoUserIU input);

    public AuthResponse login(AuthRequest input);

    public AuthResponse refreshToken(RefreshTokenRequest input);
}
