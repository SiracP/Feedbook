package com.sirac.service.impl;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.DtoTopic;
import com.sirac.dto.DtoUser;
import com.sirac.dto.dto_insert_update.DtoTopicIU;
import com.sirac.exception.BaseException;
import com.sirac.exception.ErrorMessage;
import com.sirac.exception.MessageType;
import com.sirac.model.Entry;
import com.sirac.model.Topic;
import com.sirac.model.User;
import com.sirac.repository.EntryRepository;
import com.sirac.repository.TopicRepository;
import com.sirac.repository.UserRepository;
import com.sirac.service.ITopicService;
import com.sirac.service.SavedToDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicServiceImpl implements ITopicService, SavedToDto {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private EntryRepository entryRepository;

    private Topic createTopic(DtoTopicIU dtoTopicIU){
        Optional<User> optionalUser = userRepository.findById(dtoTopicIU.getUserId());
        if(optionalUser.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,"userId: " + dtoTopicIU.getUserId().toString()));
        }
        Topic topic = new Topic();
        topic.setCreateTime(new Date());
        topic.setUpdateTime(new Date());
        topic.setUser(optionalUser.get());
        topic.setTitle(dtoTopicIU.getTitle());
        topic.setEntryCount(0L);
        return topic;
    }

    private Topic findTopic(Long topicId){
        Optional<Topic> optionalTopic = topicRepository.findById(topicId);
        if(optionalTopic.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,"topicId: " + topicId.toString()));
        }
        return optionalTopic.get();
    }

    @Override
    public DtoTopic saveTopic(DtoTopicIU dtoTopicIU) {
        Topic savedTopic = topicRepository.save(createTopic(dtoTopicIU));
        return savedToDtoTopic(savedTopic);
    }

    @Override
    public DtoTopic deleteTopic(Long topicId) {
        Topic topic = findTopic(topicId);
        topicRepository.delete(topic);
        return savedToDtoTopic(topic);
    }

    @Override
    public List<DtoEntry> getAllEntries(Long topicId) {
        findTopic(topicId);
        List<Entry> allEntries = entryRepository.findAllByTopicId(topicId);
        List<DtoEntry> dtoEntries = new ArrayList<>();
        for (Iterator<Entry> iterator = allEntries.iterator(); iterator.hasNext();) {
            Entry next =  iterator.next();
            dtoEntries.add(savedtoDtoEntry(next));
        }
        return dtoEntries;
    }
}
