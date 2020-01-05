package com.cdk.mapper;

import org.apache.ibatis.annotations.Mapper;

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
}
