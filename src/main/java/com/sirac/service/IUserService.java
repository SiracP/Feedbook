package com.sirac.service;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.DtoUser;
import com.sirac.dto.dto_insert_update.DtoUserIU;

import java.util.List;

public interface IUserService {

    public List<DtoUser> getAllUsers();

    public DtoUser updateUser(Long userId, DtoUserIU dtoUserIU);

    public List<DtoUser> getAllFollowers(Long userId);

    public List<DtoUser> getAllFollowings(Long userId);

    public List<DtoEntry> getALlSavedEntries(Long userId);
}
