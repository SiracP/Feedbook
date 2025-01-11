package com.sirac.service;

import com.sirac.dto.DtoUser;
import com.sirac.dto.dto_insert_update.DtoUserIU;

public interface IUserService {

    public DtoUser saveUser(DtoUserIU dtoUserIU);
}
