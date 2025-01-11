package com.sirac.controller;

import com.sirac.dto.AuthRequest;
import com.sirac.dto.AuthResponse;
import com.sirac.dto.DtoUser;
import com.sirac.dto.RefreshTokenRequest;
import com.sirac.dto.dto_insert_update.DtoUserIU;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(DtoUserIU input);

    public RootEntity<AuthResponse> login(AuthRequest input);

    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
