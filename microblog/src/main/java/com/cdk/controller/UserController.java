package com.cdk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdk.entity.FeedObject;
import com.cdk.entity.User;
import com.cdk.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	@ResponseBody
	public FeedObject checkUser(HttpServletRequest request,String userName,String userPwd) {
		FeedObject fo = new FeedObject();
		List<User> list = userService.checkUser(userName, userPwd);
		fo.setState(list.size()>0);
		
		if(!(list.size()>0)) {
			fo.setMsg("登录失败");
		}else {
			fo.setMsg("登录成功。");
			request.getSession().setAttribute("user", list.get(0));
			fo.setObj(list.get(0));
		}
		return fo;
	}
	/**
	 * 监测登录状态
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkLogin")
	public FeedObject checkLogin(HttpServletRequest request) {
		FeedObject fo = new FeedObject();
		User user = (User) request.getSession().getAttribute("user");
		fo.setState(user!=null);
		fo.setObj(user);
		return fo;
		
	}
	
	@ResponseBody
	@RequestMapping("/quit")
	public FeedObject quit(HttpServletRequest request) {
		FeedObject fo = new FeedObject();
		request.getSession().removeAttribute("user");
		fo.setState(true);
		return fo;
	}
}
