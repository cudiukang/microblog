package com.cdk.controller;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdk.entity.AnswerDTO;
import com.cdk.entity.FeedObject;

import com.cdk.entity.Question;
import com.cdk.entity.QuestionAnswer;
import com.cdk.entity.QuestionFollow;
import com.cdk.entity.QuestionVO;
import com.cdk.entity.User;
import com.cdk.service.QuestionAnswerService;
import com.cdk.service.QuestionFollowService;
import com.cdk.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuestionFollowService questionFollowService;
	
	@Autowired
	private QuestionAnswerService questionAnswerService;
	
	/**
	 * 获取分页数据
	 * @return
	 */
	@RequestMapping("/searchQues")
	@ResponseBody
	public FeedObject getQuertionPage(Integer curPage,Integer pageSize,
			String searchInfo) {
		FeedObject fo = new FeedObject();
		
		//封装数据
		Map<String, Object> map = new HashMap<String, Object>();
		//获取分页数据
		List<QuestionVO> list = questionService.getQuertionPage(curPage,pageSize,
				searchInfo);
		//获取总条数
		map.put("data", list);
		map.put("total", questionService.getQuertionPageCount(searchInfo));
		
		fo.setState(true);
		fo.setObj(map);
		
		return fo;
	}
	
	@ResponseBody
	@RequestMapping("getHotInfo")
	public FeedObject getHotInfo() {
		FeedObject fo = new FeedObject();
		
		List<Question> list = questionService.getHotInfo();
		fo.setState(true);
		fo.setObj(list);

		
		return fo;
	}
	/**
	 * 问题详情页面
	 * @return
	 */
	@RequestMapping("questionDetail")
	public String questionDetail(Model model,Integer id) {
		
		QuestionVO qvo = questionService.getQuestionById(id);
		qvo.setViewCount(qvo.getViewCount()+1);
		questionService.updateQuestionById(qvo);
		model.addAttribute("dto", qvo);
		
		List<AnswerDTO> list = questionAnswerService.getAnswerById(qvo.getQuestionId());
		model.addAttribute("answers", list);
		
		return "questionDetail";
	}
	/**
	 * 关注
	 * @return
	 */
	@ResponseBody
	@RequestMapping("followQuestion")
	public FeedObject followQuestion(HttpServletRequest request,
			boolean followState,Integer questionId) {
		FeedObject fo = new FeedObject();
		fo.setState(true);
		
		//获取当前用户id
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			fo.setState(false);
			fo.setMsg("请先登录。");
			return fo;
		}
		Integer userId = user.getUserId();
		QuestionFollow qf = new QuestionFollow();
		qf.setFollowUserId(userId);
		qf.setQuestionId(questionId);
		
		if(!followState) {//添加关注
			//添加关注信息
			questionFollowService.addQuestionFollow(qf);
		}else {//取消关注
			//删除关注信息
			questionFollowService.removeQuestionFollow(qf);
		}
		
		return fo;
	}
	/**
	 * 点赞
	 * @return
	 */
	@ResponseBody
	@RequestMapping("okQuestion")
	public FeedObject okQuestion(HttpServletRequest request,
			boolean followState,Integer questionId) {
		FeedObject fo = new FeedObject();
		fo.setState(true);
		
		//获取当前用户id
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			fo.setState(false);
			fo.setMsg("请先登录。");
			return fo;
		}
		
		if(!followState) {//添加关注
			//修改点赞的关注数据
			QuestionVO qvo = questionService.getQuestionById(questionId);
			qvo.setLikeCount(qvo.getLikeCount()+1);
			questionService.updateQuestionById(qvo);
		}else {
			//修改点赞的关注数据
			QuestionVO qvo = questionService.getQuestionById(questionId);
			qvo.setLikeCount(qvo.getLikeCount()-1);
			questionService.updateQuestionById(qvo);
		}
		
		return fo;
	}
	
	@RequestMapping("answerQuestion")
	@ResponseBody
	public FeedObject answerQuestion(HttpServletRequest request,
			String answerText,Integer questionId) {
		FeedObject fo = new FeedObject();
		fo.setState(true);
		
		//获取当前用户id
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			fo.setState(false);
			fo.setMsg("请先登录。");
			return fo;
		}
		
		//封装数据并添加到数据库
		QuestionAnswer qa = new QuestionAnswer();
		qa.setAnswerPersonId(user.getUserId());
		qa.setQuestionId(questionId);
		qa.setAnswerContent(answerText);
		qa.setAnswerTime(new Date().getTime());
		questionAnswerService.addQuestionAnswer(qa);
		
		return fo;
	}
}
