package com.cdk.entity;

public class QuestionFollow {
	private Integer followId;
	
	private Integer questionId;
	
	private Integer followUserId;

	public Integer getFollowId() {
		return followId;
	}

	public void setFollowId(Integer followId) {
		this.followId = followId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getFollowUserId() {
		return followUserId;
	}

	public void setFollowUserId(Integer followUserId) {
		this.followUserId = followUserId;
	}
	
}
