package com.sirac.controller;

import com.sirac.dto.DtoEntry;
import com.sirac.dto.DtoTopic;
import com.sirac.dto.dto_insert_update.DtoTopicIU;

import java.util.List;

public interface IRestTopicController {

    public RootEntity<DtoTopic> saveTopic(DtoTopicIU dtoTopicIU);

    public RootEntity<DtoTopic> deleteTopic(Long topicId);

    public RootEntity<List<DtoEntry>>  getAllEntries(Long topicId);
}
