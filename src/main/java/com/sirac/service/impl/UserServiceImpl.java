package com.sirac.service.impl;

import com.sirac.dto.DtoUser;
import com.sirac.dto.dto_insert_update.DtoUserIU;
import com.sirac.model.User;
import com.sirac.repository.UserRepository;
import com.sirac.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    private User createUser(DtoUserIU dtoUserIU){
        User user = new User();
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setNickname(dtoUserIU.getNickname());
        user.setFollowersCount(0L);
        user.setFollowingCount(0L);
        return user;
    }

    @Override
    public DtoUser saveUser(DtoUserIU dtoUserIU) {
        User savedUser = userRepository.save(createUser(dtoUserIU));
        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(savedUser,dtoUser);
        return dtoUser;
    }
}
