package com.cdk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.entity.User;
import com.cdk.mapper.UserMapper;
import com.cdk.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public boolean checkUser(String userName, String userPwd) {
		List<User> list = userMapper.checkUser(userName, userPwd);
		return list.size()>0;
	}
	
}
