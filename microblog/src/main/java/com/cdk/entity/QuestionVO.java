package com.cdk.entity;

import java.util.Date;

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
