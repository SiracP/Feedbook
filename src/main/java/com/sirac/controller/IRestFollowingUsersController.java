package com.sirac.controller;

import com.sirac.dto.DtoFollowingUsers;
import com.sirac.dto.dto_insert_update.DtoFollowingUsersIU;

public interface IRestFollowingUsersController {
    RootEntity<DtoFollowingUsers> followUser(DtoFollowingUsersIU dtoFollowingUsersIU);
}
