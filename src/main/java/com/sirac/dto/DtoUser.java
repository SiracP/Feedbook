package com.sirac.dto;

import lombok.Data;

@Data
public class DtoUser extends DtoBase{

    private String nickname;

    private Long followersCount;

    private Long followingCount;
}
