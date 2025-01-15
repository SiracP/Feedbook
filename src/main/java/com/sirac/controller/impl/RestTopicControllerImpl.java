package com.sirac.controller.impl;

import com.sirac.controller.IRestTopicController;
import com.sirac.controller.RestBaseController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.DtoTopic;
import com.sirac.dto.dto_insert_update.DtoTopicIU;
import com.sirac.service.ITopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/topic")
public class RestTopicControllerImpl extends RestBaseController implements IRestTopicController {

    @Autowired
    private ITopicService topicService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoTopic> saveTopic(@Valid @RequestBody DtoTopicIU dtoTopicIU) {
        return ok(topicService.saveTopic(dtoTopicIU));
    }

    @DeleteMapping("/delete/{topicId}")
    @Override
    public RootEntity<DtoTopic> deleteTopic(@RequestParam(name = "topicId") Long topicId) {
        return ok(topicService.deleteTopic(topicId));
    }
}
