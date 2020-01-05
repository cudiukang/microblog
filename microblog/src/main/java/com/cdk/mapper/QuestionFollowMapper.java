package com.cdk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdk.entity.FollowDTO;
import com.cdk.entity.QuestionFollow;

@Mapper
public interface QuestionFollowMapper {
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
