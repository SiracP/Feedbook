package com.sirac.service.impl;

import com.sirac.dto.DtoFollowingUsers;
import com.sirac.dto.dto_insert_update.DtoFollowingUsersIU;
import com.sirac.exception.BaseException;
import com.sirac.exception.ErrorMessage;
import com.sirac.exception.MessageType;
import com.sirac.model.FollowingUsers;
import com.sirac.model.SavedEntries;
import com.sirac.model.User;
import com.sirac.repository.FollowingUsersRepository;
import com.sirac.repository.UserRepository;
import com.sirac.service.IFollowingUsersService;
import com.sirac.service.SavedToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class FollowingUsersServiceImpl implements IFollowingUsersService, SavedToDto {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FollowingUsersRepository followingUsersRepository;

    private User increaseFollowingCount(User follower){
        follower.setFollowingCount(follower.getFollowingCount()+1);
        return userRepository.save(follower);
    }
    private User increaseFollowerCount(User following){
        following.setFollowersCount(following.getFollowersCount()+1);
        return userRepository.save(following);
    }

    private FollowingUsers createFollowingUsers(DtoFollowingUsersIU dtoFollowingUsersIU){
        Optional<User> optionalFollowerId = userRepository.findById(dtoFollowingUsersIU.getFollowerId());
        if(optionalFollowerId.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoFollowingUsersIU.getFollowerId().toString()));
        }
        Optional<User> optionalFollowingId = userRepository.findById(dtoFollowingUsersIU.getFollowingId());
        if(optionalFollowingId.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoFollowingUsersIU.getFollowingId().toString()));
        }
        FollowingUsers followingUsers = new FollowingUsers();
        followingUsers.setCreateTime(new Date());
        followingUsers.setUpdateTime(new Date());
        followingUsers.setFollower(increaseFollowingCount(optionalFollowerId.get()));
        followingUsers.setFollowing(increaseFollowerCount(optionalFollowingId.get()));

        return followingUsers;
    }

    @Override
    public DtoFollowingUsers followUser(DtoFollowingUsersIU dtoFollowingUsersIU) {
        FollowingUsers savedFollowingUsers = followingUsersRepository.save(createFollowingUsers(dtoFollowingUsersIU));
        return savedtoDtoSavedEntry(savedFollowingUsers);
    }
}
