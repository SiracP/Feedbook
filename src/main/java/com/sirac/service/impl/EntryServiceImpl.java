package com.sirac.service.impl;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.DtoTopic;
import com.sirac.dto.DtoUser;
import com.sirac.dto.dto_insert_update.DtoEntryIU;
import com.sirac.exception.BaseException;
import com.sirac.exception.ErrorMessage;
import com.sirac.exception.MessageType;
import com.sirac.model.Entry;
import com.sirac.model.Topic;
import com.sirac.model.User;
import com.sirac.repository.EntryRepository;
import com.sirac.repository.TopicRepository;
import com.sirac.repository.UserRepository;
import com.sirac.service.IEntryService;
import com.sirac.service.SavedToDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class EntryServiceImpl implements IEntryService, SavedToDto {

    @Autowired
    private EntryRepository entryRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    private Topic increaseEntryCount(Topic entryTopic){
        entryTopic.setEntryCount(entryTopic.getEntryCount() + 1);
        return topicRepository.save(entryTopic);
    }
    private void decreaseEntryCount(Topic entryTopic){
        entryTopic.setEntryCount(entryTopic.getEntryCount() - 1);
        topicRepository.save(entryTopic);
    }

    private Entry createEntry(DtoEntryIU dtoEntryIU){
        Optional<Topic> optionalTopic = topicRepository.findById(dtoEntryIU.getTopicId());
        if(optionalTopic.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,"topicId: " + dtoEntryIU.getTopicId().toString()));
        }
        Optional<User> optionalUser = userRepository.findById(dtoEntryIU.getUserId());
        if(optionalUser.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,"userId: " +dtoEntryIU.getUserId().toString()));
        }
        Entry entry = new Entry();
        entry.setContent(dtoEntryIU.getContent());
        entry.setUser(optionalUser.get());
        entry.setTopic(increaseEntryCount(optionalTopic.get()));
        entry.setCreateTime(new Date());
        entry.setUpdateTime(new Date());
        entry.setLikeCount(0L);
        return entry;
    }

    private Entry findEntry(Long entryId){
        Optional<Entry> optionalEntry = entryRepository.findById(entryId);
        if(optionalEntry.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,"entryId: " + entryId.toString()));
        }
        return optionalEntry.get();
    }

    @Override
    public DtoEntry saveEntry(DtoEntryIU dtoEntryIU) {
        Entry savedEntry = entryRepository.save(createEntry(dtoEntryIU));

        return savedtoDtoEntry(savedEntry);
    }

    @Override
    public DtoEntry deleteEntry(Long entryId){
        Entry entry = findEntry(entryId);
        decreaseEntryCount(entry.getTopic());
        entryRepository.delete(entry);
        return savedtoDtoEntry(entry);
    }
}
