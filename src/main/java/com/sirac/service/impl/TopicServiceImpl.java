package com.sirac.service.impl;

import com.sirac.dto.DtoTopic;
import com.sirac.dto.DtoUser;
import com.sirac.dto.dto_insert_update.DtoTopicIU;
import com.sirac.exception.BaseException;
import com.sirac.exception.ErrorMessage;
import com.sirac.exception.MessageType;
import com.sirac.model.Topic;
import com.sirac.model.User;
import com.sirac.repository.TopicRepository;
import com.sirac.repository.UserRepository;
import com.sirac.service.ITopicService;
import com.sirac.service.SavedToDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TopicServiceImpl implements ITopicService, SavedToDto {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    private Topic createTopic(DtoTopicIU dtoTopicIU){
        Optional<User> optionalUser = userRepository.findById(dtoTopicIU.getUserId());
        if(optionalUser.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,dtoTopicIU.getUserId().toString()));
        }
        Topic topic = new Topic();
        topic.setCreateTime(new Date());
        topic.setUpdateTime(new Date());
        topic.setUser(optionalUser.get());
        topic.setTitle(dtoTopicIU.getTitle());
        topic.setEntryCount(0L);
        return topic;
    }

    @Override
    public DtoTopic saveTopic(DtoTopicIU dtoTopicIU) {
        Topic savedTopic = topicRepository.save(createTopic(dtoTopicIU));
        return savedToDtoTopic(savedTopic);
    }
}
