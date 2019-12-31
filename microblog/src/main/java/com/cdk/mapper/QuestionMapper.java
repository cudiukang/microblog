package com.cdk.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.cdk.entity.Question;

@Mapper
public interface QuestionMapper {
	@Insert("insert into question(q_title,description,gmt_create,gmt_modify,view_count,like_count,comment_count,tag,creator_id) values (#{qTitle},#{description},#{gmtCreate},#{gmtModify},#{viewCount},#{likeCount},#{commentCount},#{tag},#{creatorId})")
	Integer addQuestion(Question question);
}
