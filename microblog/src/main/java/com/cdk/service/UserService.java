package com.cdk.service;

import com.cdk.entity.User;
import java.util.List;;

public interface UserService {
	/**
	 * 根据用户名和密码获取登录状态
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	List<User> checkUser(String userName,String userPwd);
}
