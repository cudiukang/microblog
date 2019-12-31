package com.cdk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.entity.Question;
import com.cdk.mapper.QuestionMapper;
import com.cdk.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionMapper questionMapper;

	@Override
	public Integer addQuestion(Question question) {
		return questionMapper.addQuestion(question);
	}

}
