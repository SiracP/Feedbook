package com.sirac.service;

import com.sirac.dto.DtoLike;
import com.sirac.dto.dto_insert_update.DtoLikeIU;

public interface ILikesService {

    public DtoLike likeAEntry(DtoLikeIU dtoLikeIU);

    public DtoLike dislikeEntry(DtoLikeIU dtoLikeIU);
}
