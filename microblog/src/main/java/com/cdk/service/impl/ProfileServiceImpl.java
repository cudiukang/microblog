package com.cdk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.entity.QuestionVO;
import com.cdk.mapper.ProfileMapper;
import com.cdk.service.ProfileService;
import com.github.pagehelper.PageHelper;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileMapper profileMapper ;
	
	@Override
	public List<QuestionVO> getProfilePage(String searchInfo, Integer userId,
			Integer curPage,Integer pageSize) {
		PageHelper.startPage(curPage, pageSize);
		List<QuestionVO> list = profileMapper.getProfilePage(searchInfo, userId);
		return list;
	}
	
	@Override
	public Integer getProfilePageCount(String searchInfo, Integer userId) {
		return profileMapper.getProfilePageCount(searchInfo, userId);
	}
	
}
