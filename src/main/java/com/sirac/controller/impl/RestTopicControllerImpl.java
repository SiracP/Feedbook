package com.sirac.controller.impl;

import com.sirac.controller.IRestTopicController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.DtoTopic;
import com.sirac.dto.dto_insert_update.DtoTopicIU;
import com.sirac.service.ITopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sirac.controller.RootEntity.ok;

@RestController
@RequestMapping("/rest/api/topic")
public class RestTopicControllerImpl implements IRestTopicController {

    @Autowired
    private ITopicService topicService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoTopic> saveTopic(@Valid @RequestBody DtoTopicIU dtoTopicIU) {
        return ok(topicService.saveTopic(dtoTopicIU));
    }
}
