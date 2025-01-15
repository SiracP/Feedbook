package com.sirac.service;

import com.sirac.dto.*;
import com.sirac.model.*;
import org.springframework.beans.BeanUtils;

public interface SavedToDto {

    default DtoUser savedToDtoUser(User savedUser){
        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(savedUser,dtoUser);

        return dtoUser;
    }

    default DtoTopic savedToDtoTopic(Topic savedTopic){
        DtoTopic dtoTopic = new DtoTopic();
        BeanUtils.copyProperties(savedTopic,dtoTopic);

        dtoTopic.setUser(savedToDtoUser(savedTopic.getUser()));

        return dtoTopic;
    }

    default DtoEntry savedtoDtoEntry(Entry savedEntry){
        DtoEntry dtoEntry = new DtoEntry();
        BeanUtils.copyProperties(savedEntry,dtoEntry);

        dtoEntry.setUser(savedToDtoUser(savedEntry.getUser()));
        dtoEntry.setTopic(savedToDtoTopic(savedEntry.getTopic()));

        return dtoEntry;
    }
    default DtoLike savedtoDtoLike(Likes savedLike){
        DtoLike dtoLike = new DtoLike();
        BeanUtils.copyProperties(savedLike,dtoLike);

        dtoLike.setUser(savedToDtoUser(savedLike.getUser()));
        dtoLike.setEntry(savedtoDtoEntry(savedLike.getEntry()));

        return dtoLike;
    }

    default DtoSavedEntries savedtoDtoSavedEntry(SavedEntries savedEntries){
        DtoSavedEntries dtoSavedEntries = new DtoSavedEntries();
        BeanUtils.copyProperties(savedEntries,dtoSavedEntries);

        dtoSavedEntries.setUser(savedToDtoUser(savedEntries.getUser()));
        dtoSavedEntries.setEntry((savedtoDtoEntry(savedEntries.getEntry())));

        return  dtoSavedEntries;
    }

    default DtoFollowingUsers savedtoDtoSavedEntry(FollowingUsers followingUsers){
        DtoFollowingUsers dtoFollowingUsers = new DtoFollowingUsers();
        BeanUtils.copyProperties(followingUsers,dtoFollowingUsers);

        dtoFollowingUsers.setFollower(savedToDtoUser(followingUsers.getFollower()));
        dtoFollowingUsers.setFollowing((savedToDtoUser(followingUsers.getFollowing())));

        return  dtoFollowingUsers;
    }
}
