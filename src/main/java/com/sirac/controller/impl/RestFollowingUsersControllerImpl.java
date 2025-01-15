package com.sirac.controller.impl;

import com.sirac.controller.IRestFollowingUsersController;
import com.sirac.controller.RestBaseController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.DtoFollowingUsers;
import com.sirac.dto.dto_insert_update.DtoFollowingUsersIU;
import com.sirac.service.IFollowingUsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/following-user")
public class RestFollowingUsersControllerImpl extends RestBaseController implements IRestFollowingUsersController {

    @Autowired
    private IFollowingUsersService followingUsersService;

    @PostMapping("/follow-user")
    @Override
    public RootEntity<DtoFollowingUsers> followUser(@Valid @RequestBody DtoFollowingUsersIU dtoFollowingUsersIU) {
        return ok(followingUsersService.followUser(dtoFollowingUsersIU));
    }

    @DeleteMapping("/unfollow-user")
    @Override
    public RootEntity<DtoFollowingUsers> unfollowUser(@Valid @RequestBody DtoFollowingUsersIU dtoFollowingUsersIU) {
        return ok(followingUsersService.unfollowUser(dtoFollowingUsersIU));
    }
}
