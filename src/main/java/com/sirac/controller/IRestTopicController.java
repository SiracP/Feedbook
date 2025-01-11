package com.sirac.controller;

import com.sirac.dto.DtoTopic;
import com.sirac.dto.dto_insert_update.DtoTopicIU;

public interface IRestTopicController {

    public RootEntity<DtoTopic> saveTopic(DtoTopicIU dtoTopicIU);
}
