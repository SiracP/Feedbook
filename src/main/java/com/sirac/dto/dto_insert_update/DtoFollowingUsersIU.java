package com.sirac.dto.dto_insert_update;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoFollowingUsersIU {

    @NotNull
    private Long followerId;

    @NotNull
    private Long followingId;
}
