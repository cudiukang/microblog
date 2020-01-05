package com.cdk.service;

import java.util.List;

import com.cdk.entity.FollowDTO;
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
	/**
	 * 根据用户id获取关注列表
	 * @param userId
	 * @return
	 */
	List<FollowDTO> getFollowByUserId(Integer userId);
}
