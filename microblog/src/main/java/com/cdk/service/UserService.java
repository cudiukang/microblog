package com.cdk.service;

public interface UserService {
	/**
	 * 根据用户名和密码获取登录状态
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public boolean checkUser(String userName,String userPwd);
}
