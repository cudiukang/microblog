package com.cdk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cdk.entity.QuestionVO;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface ProfileMapper {
	/**
	 * 获取问题分页数据
	 * @return
	 */
	List<QuestionVO> getProfilePage(@Param("searchInfo")String searchInfo,
			@Param("userId")Integer userId);
	/**
	 * 获取总条数
	 * @param searchInfo
	 * @return
	 */
	Integer getProfilePageCount(@Param("searchInfo")String searchInfo,
			@Param("userId")Integer userId);
}
