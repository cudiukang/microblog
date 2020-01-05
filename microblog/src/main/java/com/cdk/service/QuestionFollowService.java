package com.cdk.service;

import com.cdk.entity.QuestionFollow;

public interface QuestionFollowService {
	/**
	 * 根据对象添加数据
	 * @param qf
	 * @return
	 */
	Integer addQuestionFollow(QuestionFollow qf);
	/**
	 * 根据对象删除数据
	 * @param qf
	 * @return
	 */
	Integer removeQuestionFollow(QuestionFollow qf);
}
