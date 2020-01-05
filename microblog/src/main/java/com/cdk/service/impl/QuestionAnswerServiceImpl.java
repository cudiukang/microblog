package com.cdk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.entity.AnswerDTO;
import com.cdk.entity.QuestionAnswer;
import com.cdk.mapper.QuestionAnswerMapper;
import com.cdk.service.QuestionAnswerService;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
	@Autowired
	private QuestionAnswerMapper questionAnswerMapper;

	@Override
	public Integer addQuestionAnswer(QuestionAnswer qa) {
		return questionAnswerMapper.addQuestionAnswer(qa);
	}

	@Override
	public List<AnswerDTO> getAnswerById(Integer questionId) {
		return questionAnswerMapper.getAnswerById(questionId);
	}
	
}
