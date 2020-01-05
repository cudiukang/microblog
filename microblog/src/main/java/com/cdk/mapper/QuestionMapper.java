package com.cdk.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.cdk.entity.Question;
import com.cdk.entity.QuestionVO;

@Mapper
public interface QuestionMapper {
	/**
	 * 新增问题
	 * @param question
	 * @return
	 */
	@Insert("insert into question(q_title,description,gmt_create,gmt_modify,view_count,like_count,comment_count,tag,creator_id) values (#{qTitle},#{description},#{gmtCreate},#{gmtModify},#{viewCount},#{likeCount},#{commentCount},#{tag},#{creatorId})")
	Integer addQuestion(Question question);
	/**
	 * 获取问题分页数据
	 * @return
	 */
	List<QuestionVO> getQuertionPage(String searchInfo);
	/**
	 * 获取总条数
	 * @param searchInfo
	 * @return
	 */
	Integer getQuertionPageCount(String searchInfo);
	/**
	 * 获取热点信息
	 * @return
	 */
	List<Question> getHotInfo();
	/**
	 * 根据id查询问题
	 * @return
	 */
	QuestionVO getQuestionById(Integer id);
	/**
	 * 根据对象修改question
	 * @param q
	 * @return
	 */
	Integer updateQuestionById(QuestionVO q);
	/**
	 * 根据用户id查询问题
	 * @param userId
	 * @return
	 */
	List<Question> getQuestionByUserId(Integer userId);
}
