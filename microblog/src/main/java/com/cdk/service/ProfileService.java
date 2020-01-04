package com.cdk.service;

import java.util.List;

import com.cdk.entity.QuestionVO;

public interface ProfileService {
	/**
	 * 获取问题分页数据
	 * @return
	 */
	List<QuestionVO> getProfilePage(String searchInfo,Integer userId,
			Integer curPage,Integer pageSize);
	/**
	 * 获取总条数
	 * @param searchInfo
	 * @return
	 */
	Integer getProfilePageCount(String searchInfo,Integer userId);
}
