package com.cdk.service;

import com.cdk.entity.Question;

/**
 * 问题业务层
 * @author cuidukang
 *
 */
public interface QuestionService {
	/**
	 * 新增业务
	 * @param question
	 * @return
	 */
	Integer addQuestion(Question question);
}
