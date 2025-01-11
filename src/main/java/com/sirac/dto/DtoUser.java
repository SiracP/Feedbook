package com.sirac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoUser extends DtoBase{

    private String username;

    private String password;

    private String nickname;

    private Long followersCount;

    private Long followingCount;
}
