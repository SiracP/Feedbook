package com.sirac.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoFollowingUsers {

    private DtoUser follower;

    private DtoUser following;
}
