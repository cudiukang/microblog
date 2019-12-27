package com.cdk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cdk.entity.User;


@Mapper
public interface UserMapper {
	/**
	 * 根据用户名和密码获取用户对象
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	//@Select("select * from user where u_name=#{userName} and u_pwd=#{userPwd}")
	public List<User> checkUser(@Param("userName")String userName,
			@Param("userPwd") String userPwd);
}
