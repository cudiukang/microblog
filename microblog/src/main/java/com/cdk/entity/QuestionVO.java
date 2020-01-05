package com.cdk.entity;

public class QuestionVO {
	private Integer questionId;
	
	private String qTitle;
	
	private String description;
	
	private Long gmtCreate;
	
	private Long gmtModify;
	
	private Integer viewCount;
	
	private Integer likeCount;
	
	private Integer commentCount;
	
	private String tag;
	
	private Integer creatorId;
	
	private String uHeadUrl;
	
	private String uName;
	
	private String uRealName;
	
	private String uSex;
	
	private String uAddr;
	
	private Integer uAge;
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuRealName() {
		return uRealName;
	}
	public void setuRealName(String uRealName) {
		this.uRealName = uRealName;
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
	public String getuHeadUrl() {
		return uHeadUrl;
	}
	public void setuHeadUrl(String uHeadUrl) {
		this.uHeadUrl = uHeadUrl;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Long gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Long getGmtModify() {
		return gmtModify;
	}
	public void setGmtModify(Long gmtModify) {
		this.gmtModify = gmtModify;
	}
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	public Integer getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	
}
