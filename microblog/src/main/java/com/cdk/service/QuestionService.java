package com.cdk.service;

import java.util.List;

import com.cdk.entity.Question;
import com.cdk.entity.QuestionVO;
import com.cdk.entity.User;

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
	/**
	 * 获取问题分页查询
	 * @return
	 */
	List<QuestionVO> getQuertionPage(Integer pageNumber,Integer pageSize,
			String searchInfo);
	/**
	 * 查询总条数
	 * @param searchInfo
	 * @return
	 */
	Integer getQuertionPageCount(String searchInfo);
	/**
	 * 获取热点信息
	 * @return
	 */
	List<Question> getHotInfo();
}
