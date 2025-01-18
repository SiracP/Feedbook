package com.sirac.controller.impl;

import com.sirac.controller.IRestUserController;
import com.sirac.controller.RestBaseController;
import com.sirac.controller.RootEntity;
import com.sirac.dto.DtoUser;
import com.sirac.dto.dto_insert_update.DtoUserIU;
import com.sirac.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/user")
public class RestUserControllerImpl extends RestBaseController implements IRestUserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/get-all-users")
    @Override
    public RootEntity<List<DtoUser>> getAllUsers() {
        return ok(userService.getAllUsers());
    }

    @PutMapping("/update-user/{userId}")
    @Override
    public RootEntity<DtoUser> updateUser(@PathVariable(name = "userId") Long userId,@Valid @RequestBody DtoUserIU dtoUserIU) {
        return ok(userService.updateUser(userId,dtoUserIU));
    }

    @GetMapping("/get-all-followers/{userId}")
    @Override
    public RootEntity<List<DtoUser>> getAllFollowers(Long userId) {
        return ok(userService.getAllFollowers(userId));
    }

    @GetMapping("/get-all-followings/{userId}")
    @Override
    public RootEntity<List<DtoUser>> getAllFollowings(Long userId) {
        return ok(userService.getAllFollowings(userId));
    }
}
