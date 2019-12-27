package com.cdk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdk.entity.FeedObject;
import com.cdk.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public FeedObject checkUser(String userName,String userPwd) {
		FeedObject fo = new FeedObject();
		boolean res = userService.checkUser(userName, userPwd);
		fo.setState(res);
		fo.setMsg("登录成功。");
		if(!res) {
			fo.setMsg("登录失败");
		}
		return fo;
	}
}
