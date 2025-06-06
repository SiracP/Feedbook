package com.sirac.dto.dto_insert_update;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoUserIU {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String nickname;

    private Long followersCount;

    private Long followingCount;
}
