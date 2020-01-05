package com.cdk.entity;

public class AnswerDTO extends QuestionVO {
	private Integer answerId;
	
	private Integer questionId;
	
	private Integer answerPersonId;
	
	private String answerContent;
	
	private String remark;
	
	private Long answerTime;

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getAnswerPersonId() {
		return answerPersonId;
	}

	public void setAnswerPersonId(Integer answerPersonId) {
		this.answerPersonId = answerPersonId;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(Long answerTime) {
		this.answerTime = answerTime;
	}
	
	
}
