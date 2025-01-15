package com.sirac.controller.impl;

import com.sirac.controller.IRestLikeController;
import com.sirac.controller.RestBaseController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.DtoLike;
import com.sirac.dto.dto_insert_update.DtoLikeIU;
import com.sirac.service.ILikesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/like")
public class RestLikeControllerImpl extends RestBaseController implements IRestLikeController {

    @Autowired
    private ILikesService likesService;

    @PostMapping("/like-entry")
    @Override
    public RootEntity<DtoLike> likeAEntry(@Valid @RequestBody DtoLikeIU dtoLikeIU) {
        return ok(likesService.likeAEntry(dtoLikeIU));
    }

    @DeleteMapping("/dislike-entry")
    @Override
    public RootEntity<DtoLike> dislikeEntry(@Valid @RequestBody DtoLikeIU dtoLikeIU) {
        return ok(likesService.dislikeEntry(dtoLikeIU));
    }
}
