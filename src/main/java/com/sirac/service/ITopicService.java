package com.sirac.service;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.DtoTopic;
import com.sirac.dto.dto_insert_update.DtoTopicIU;

import java.util.List;

public interface ITopicService {

    public DtoTopic saveTopic(DtoTopicIU dtoTopicIU);

    public DtoTopic deleteTopic(Long topicId);

    public List<DtoEntry> getAllEntries(Long topicId);
}
