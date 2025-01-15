package com.sirac.service.impl;

import com.sirac.dto.DtoLike;
import com.sirac.dto.dto_insert_update.DtoLikeIU;
import com.sirac.exception.BaseException;
import com.sirac.exception.ErrorMessage;
import com.sirac.exception.MessageType;
import com.sirac.model.Entry;
import com.sirac.model.Likes;
import com.sirac.model.SavedEntries;
import com.sirac.model.User;
import com.sirac.repository.EntryRepository;
import com.sirac.repository.LikesRepository;
import com.sirac.repository.UserRepository;
import com.sirac.service.ILikesService;
import com.sirac.service.SavedToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class LikesServiceImpl implements ILikesService, SavedToDto {

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private UserRepository userRepository;

    private Entry increaseLikeCount(Entry likeEntry){
        likeEntry.setLikeCount(likeEntry.getLikeCount()+1);
        return entryRepository.save(likeEntry);
    }
    private void decreaseLikeCount(Entry likeEntry){
        likeEntry.setLikeCount(likeEntry.getLikeCount()-1);
        entryRepository.save(likeEntry);
    }

    private Likes createLike(DtoLikeIU dtoLikeIU){
        Optional<Likes> optionalLike = likesRepository
                .findDistinctByUserIdAndEntryId(dtoLikeIU.getUserId(),dtoLikeIU.getEntryId());
        if(optionalLike.isPresent()){
            throw new BaseException(new ErrorMessage(MessageType.RECORD_ALREADY_EXIST,
                    "userId: " + dtoLikeIU.getUserId().toString()+
                    " & entryId: " + dtoLikeIU.getEntryId().toString()));
        }
        Optional<Entry> optionalEntry = entryRepository.findById(dtoLikeIU.getEntryId());
        if(optionalEntry.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,"entryId: " + dtoLikeIU.getEntryId().toString()));
        }
        Optional<User> optionalUser = userRepository.findById(dtoLikeIU.getUserId());
        if(optionalUser.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,"userId: " + dtoLikeIU.getUserId().toString()));
        }
        Likes likes = new Likes();
        likes.setCreateTime(new Date());
        likes.setUpdateTime(new Date());
        likes.setUser(optionalUser.get());
        likes.setEntry(increaseLikeCount(optionalEntry.get()));
        return likes;
    }
    private Likes findLike(DtoLikeIU dtoLikeIU){
        Optional<Likes> optionalLike = likesRepository
                .findDistinctByUserIdAndEntryId(dtoLikeIU.getUserId(),dtoLikeIU.getEntryId());
        if(optionalLike.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,
                    "userId: " + dtoLikeIU.getUserId().toString() +
                            " & entryId: " + dtoLikeIU.getEntryId().toString()));
        }
        return optionalLike.get();
    }

    @Override
    public DtoLike likeAEntry(DtoLikeIU dtoLikeIU) {
        Likes savedLike = likesRepository.save(createLike(dtoLikeIU));

        return savedtoDtoLike(savedLike);
    }

    @Override
    public DtoLike dislikeEntry(DtoLikeIU dtoLikeIU) {
        Likes like = findLike(dtoLikeIU);
        decreaseLikeCount(like.getEntry());
        likesRepository.delete(like);
        return savedtoDtoLike(like);
    }
}
