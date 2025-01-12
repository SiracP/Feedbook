package com.sirac.controller;

import com.sirac.dto.DtoLike;
import com.sirac.dto.dto_insert_update.DtoLikeIU;

public interface IRestLikeController {

    public RootEntity<DtoLike> likeAEntry(DtoLikeIU dtoLikeIU);
}
