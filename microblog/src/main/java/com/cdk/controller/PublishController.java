package com.cdk.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdk.entity.FeedObject;
import com.cdk.entity.Question;
import com.cdk.entity.User;
import com.cdk.service.QuestionService;

@Controller
public class PublishController {
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/publish")
	public String publishPage() {
		return "publish";
	}
	
	@ResponseBody
	@RequestMapping("/addQuestion")
	public FeedObject addQuestion(HttpServletRequest request,Question question) {
		FeedObject fo = new FeedObject();
		
		//获取登陆用户名
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			fo.setState(false);
			fo.setMsg("用户没有登录。");
			return fo;
		}
		
		//添加问题信息
		question.setCreatorId(user.getUserId());
		question.setLikeCount(0);
		question.setViewCount(0);
		question.setCommentCount(0);
		question.setGmtCreate(new Date());
		
		Integer rows = questionService.addQuestion(question);
		
		if(rows>0) {
			fo.setState(true);
			fo.setMsg("新增问题成功。");
		}else {
			fo.setState(false);
			fo.setMsg("新增问题失败。");
		}
		
		return fo;
	}
}
