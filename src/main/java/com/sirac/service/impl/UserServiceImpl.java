package com.sirac.service.impl;


import com.sirac.dto.DtoUser;
import com.sirac.dto.dto_insert_update.DtoUserIU;
import com.sirac.exception.BaseException;
import com.sirac.exception.ErrorMessage;
import com.sirac.exception.MessageType;
import com.sirac.model.FollowingUsers;
import com.sirac.model.User;
import com.sirac.repository.FollowingUsersRepository;
import com.sirac.repository.UserRepository;
import com.sirac.service.IUserService;
import com.sirac.service.SavedToDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService, SavedToDto {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private FollowingUsersRepository followingUsersRepository;

    private User findUser(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,"userId: " + userId.toString()));
        }
        return optionalUser.get();
    }

    @Override
    public List<DtoUser> getAllUsers() {
        List<DtoUser> dtoUsers = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
            User next =  iterator.next();
            dtoUsers.add(savedToDtoUser(next));
        }
        return dtoUsers;
    }

    @Override
    public DtoUser updateUser(Long userId, DtoUserIU dtoUserIU) {
        User user = findUser(userId);
        BeanUtils.copyProperties(dtoUserIU,user);
        user.setUpdateTime(new Date());
        user.setPassword(passwordEncoder.encode(dtoUserIU.getPassword()));
        return savedToDtoUser(userRepository.save(user));
    }

    @Override
    public List<DtoUser> getAllFollowers(Long userId) {
        findUser(userId);
        List<DtoUser> followers = new ArrayList<>();
        List<FollowingUsers> followingsList = followingUsersRepository.findByFollowingId(userId);
        for(FollowingUsers followingUsers : followingsList){
            followers.add(savedToDtoUser(followingUsers.getFollower()));
        }
        return followers;
    }

    @Override
    public List<DtoUser> getAllFollowings(Long userId) {
        findUser(userId);
        List<DtoUser> followings = new ArrayList<>();
        List<FollowingUsers> followerssList = followingUsersRepository.findByFollowerId(userId);
        for(FollowingUsers followingUsers : followerssList){
            followings.add(savedToDtoUser(followingUsers.getFollowing()));
        }
        return followings;
    }
}
