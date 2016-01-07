package com.yuanbaopu.controller.customer;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.yuanbaopu.common.CommonController;
import com.yuanbaopu.common.MessageResp;
import com.yuanbaopu.service.UserService;

@Controller
public class UserController extends CommonController {
	@Resource
	public UserService userService;
	
	public MessageResp login(String name , String password){
		return success(userService.login(name, password));
	}

}
