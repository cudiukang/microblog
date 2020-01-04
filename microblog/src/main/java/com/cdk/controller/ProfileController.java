package com.cdk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdk.entity.FeedObject;
import com.cdk.entity.User;
import com.cdk.service.ProfileService;

/**
 * 用户页面控制器
 * @author cuidukang
 *
 */
@Controller
public class ProfileController {
	@Autowired
	private ProfileService profileService;

	/**
	 * 返回用户界面
	 * @return
	 */
	@RequestMapping("/profile")
	public String getProfile() {
		return "profile";
	}
	
	@RequestMapping("/profilePage")
	@ResponseBody
	public FeedObject profilePage(HttpServletRequest request,String searchInfo,
			Integer curPage,Integer pageSize) {
		FeedObject fo = new FeedObject();
		
		//获取用户信息
		User user = (User) request.getSession().getAttribute("user");
		Integer userId = user.getUserId();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", profileService.getProfilePage(searchInfo, userId,curPage,pageSize));
		map.put("total", profileService.getProfilePageCount(searchInfo, userId));
		fo.setObj(map);
		fo.setState(true);
		
		return fo;
	}
}
