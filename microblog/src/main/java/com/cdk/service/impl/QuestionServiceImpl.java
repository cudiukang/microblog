package com.cdk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.entity.Question;
import com.cdk.entity.QuestionVO;
import com.cdk.entity.User;
import com.cdk.mapper.QuestionMapper;
import com.cdk.service.QuestionService;
import com.github.pagehelper.PageHelper;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionMapper questionMapper;

	@Override
	public Integer addQuestion(Question question) {
		return questionMapper.addQuestion(question);
	}

	@Override
	public List<QuestionVO> getQuertionPage(Integer pageNumber,Integer pageSize,
			String searchInfo) {
		PageHelper.startPage(pageNumber, pageSize);
		return questionMapper.getQuertionPage(searchInfo);
	}

	@Override
	public Integer getQuertionPageCount(String searchInfo) {
		return questionMapper.getQuertionPageCount(searchInfo);
	}

	@Override
	public List<Question> getHotInfo() {
		return questionMapper.getHotInfo();
	}

}
