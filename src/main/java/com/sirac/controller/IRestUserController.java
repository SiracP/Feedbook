package com.sirac.controller;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.DtoUser;
import com.sirac.dto.dto_insert_update.DtoUserIU;

import java.util.List;

public interface IRestUserController {

    public RootEntity<List<DtoUser>> getAllUsers();

    public RootEntity<DtoUser> updateUser(Long userId, DtoUserIU dtoUserIU);

    public RootEntity<List<DtoUser>> getAllFollowers(Long userId);

    public RootEntity<List<DtoUser>> getAllFollowings(Long userId);

    public RootEntity<List<DtoEntry>> getAllSavedEntries(Long userId);
}
