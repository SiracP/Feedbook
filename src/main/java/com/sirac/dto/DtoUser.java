package com.sirac.dto;

import lombok.Data;

@Data
public class DtoUser extends DtoBase{

    private String username;

    private String password;

    private String nickname;

    private Long followersCount;

    private Long followingCount;
}
