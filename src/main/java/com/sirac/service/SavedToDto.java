package com.sirac.service;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.DtoLike;
import com.sirac.dto.DtoTopic;
import com.sirac.dto.DtoUser;
import com.sirac.model.Entry;
import com.sirac.model.Likes;
import com.sirac.model.Topic;
import com.sirac.model.User;
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
}
