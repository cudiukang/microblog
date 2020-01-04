package com.cdk.entity;

public class User {
	private Integer userId;
	
	private String uName;
	
	private String uPwd;
	
	private String uReal_name;
	
	private String uSex;
	
	private String uAddr;
	
	private Integer uAge;
	
	private String uHeadUrl;
	
	public String getuHeadUrl() {
		return uHeadUrl;
	}
	public void setuHeadUrl(String uHeadUrl) {
		this.uHeadUrl = uHeadUrl;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuReal_name() {
		return uReal_name;
	}
	public void setuReal_name(String uReal_name) {
		this.uReal_name = uReal_name;
	}
	public String getuSex() {
		return uSex;
	}
	public void setuSex(String uSex) {
		this.uSex = uSex;
	}
	public String getuAddr() {
		return uAddr;
	}
	public void setuAddr(String uAddr) {
		this.uAddr = uAddr;
	}
	public Integer getuAge() {
		return uAge;
	}
	public void setuAge(Integer uAge) {
		this.uAge = uAge;
	}
	
	
}
