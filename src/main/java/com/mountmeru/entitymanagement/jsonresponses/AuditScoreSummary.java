package com.mountmeru.entitymanagement.jsonresponses;

import lombok.Data;

@Data
public class AuditScoreSummary {

   
	private String message;
    private Long loginUserId;
    private Integer totalNC;
    private Double avgScore;
    private String grade;
    private String gradeValue;
    
    public AuditScoreSummary()
    {
    	
    }
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(Long loginUserId) {
		this.loginUserId = loginUserId;
	}
	public Integer getTotalNC() {
		return totalNC;
	}
	public void setTotalNC(Integer totalNC) {
		this.totalNC = totalNC;
	}
	public Double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGradeValue() {
		return gradeValue;
	}
	public void setGradeValue(String gradeValue) {
		this.gradeValue = gradeValue;
	}
	 public AuditScoreSummary(String message, Long loginUserId, Integer totalNC, Double avgScore, String grade,
				String gradeValue) {
			super();
			this.message = message;
			this.loginUserId = loginUserId;
			this.totalNC = totalNC;
			this.avgScore = avgScore;
			this.grade = grade;
			this.gradeValue = gradeValue;
		}
    
}