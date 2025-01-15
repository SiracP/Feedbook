package com.sirac.controller.impl;

import com.sirac.controller.IRestUserController;
import com.sirac.controller.RestBaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/user")
public class RestUserControllerImpl extends RestBaseController implements IRestUserController {

}
