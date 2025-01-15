package com.sirac.service;

import com.sirac.dto.DtoFollowingUsers;
import com.sirac.dto.dto_insert_update.DtoFollowingUsersIU;

public interface IFollowingUsersService {
    public DtoFollowingUsers followUser(DtoFollowingUsersIU dtoFollowingUsersIU);

    public DtoFollowingUsers unfollowUser(DtoFollowingUsersIU dtoFollowingUsersIU);
}
