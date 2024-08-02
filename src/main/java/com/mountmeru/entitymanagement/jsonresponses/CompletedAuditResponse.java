package com.mountmeru.entitymanagement.jsonresponses;


import java.util.List;

import lombok.Data;

@Data
public class CompletedAuditResponse {

    private String completedaudits;
    private String numberofaudits;
    private String numberofERBCONAaudits;
    private String numberofERBTECHaudits; 
    private String numberofHSEaudits;
    private String numberofFUELaudits;
    //    private String fromdate;
//    private String todate;
    private Long userId;
    private List<CompletedAuditsTable> completedAuditList;
	public String getCompletedaudits() {
		return completedaudits;
	}
	public void setCompletedaudits(String completedaudits) {
		this.completedaudits = completedaudits;
	}
	public String getNumberofaudits() {
		return numberofaudits;
	}
	public void setNumberofaudits(String numberofaudits) {
		this.numberofaudits = numberofaudits;
	}
	public String getNumberofERBCONAaudits() {
		return numberofERBCONAaudits;
	}
	public void setNumberofERBCONAaudits(String numberofERBCONAaudits) {
		this.numberofERBCONAaudits = numberofERBCONAaudits;
	}
	public String getNumberofERBTECHaudits() {
		return numberofERBTECHaudits;
	}
	public void setNumberofERBTECHaudits(String numberofERBTECHaudits) {
		this.numberofERBTECHaudits = numberofERBTECHaudits;
	}
	public String getNumberofHSEaudits() {
		return numberofHSEaudits;
	}
	public void setNumberofHSEaudits(String numberofHSEaudits) {
		this.numberofHSEaudits = numberofHSEaudits;
	}
	public String getNumberofFUELaudits() {
		return numberofFUELaudits;
	}
	public void setNumberofFUELaudits(String numberofFUELaudits) {
		this.numberofFUELaudits = numberofFUELaudits;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<CompletedAuditsTable> getCompletedAuditList() {
		return completedAuditList;
	}
	public void setCompletedAuditList(List<CompletedAuditsTable> completedAuditList) {
		this.completedAuditList = completedAuditList;
	}
}