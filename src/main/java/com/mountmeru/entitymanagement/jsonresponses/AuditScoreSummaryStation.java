package com.mountmeru.entitymanagement.jsonresponses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuditScoreSummaryStation {

    private String stationCode;
    private Double avgScore;
    private String grade;
    private String gradeValue;
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
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
	public AuditScoreSummaryStation(String stationCode, Double avgScore, String grade, String gradeValue) {
		super();
		this.stationCode = stationCode;
		this.avgScore = avgScore;
		this.grade = grade;
		this.gradeValue = gradeValue;
	}
    
	
}