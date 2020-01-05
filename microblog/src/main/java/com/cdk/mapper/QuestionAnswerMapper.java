package com.cdk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdk.entity.AnswerDTO;
import com.cdk.entity.QuestionAnswer;

@Mapper
public interface QuestionAnswerMapper {
	/**
	 * 添加一个答复
	 * @param qa
	 * @return
	 */
	Integer addQuestionAnswer(QuestionAnswer qa);
	/**
	 * 根据问题id查询答复清单
	 * @param id
	 * @return
	 */
	List<AnswerDTO> getAnswerById(Integer questionId);
}
