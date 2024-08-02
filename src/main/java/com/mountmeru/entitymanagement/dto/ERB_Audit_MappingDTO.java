package com.mountmeru.entitymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@Data
public class ERB_Audit_MappingDTO {
	
	private long counter;
	private long createdby;
	private String audittype;
	private int header;
	private int subheader;
	private int additionalnotes;
	private int question;
	private String description;
	private int points;
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public long getCounter() {
		return counter;
	}
	public void setCounter(long counter) {
		this.counter = counter;
	}
	public long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}
	public String getAudittype() {
		return audittype;
	}
	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}
	public int getHeader() {
		return header;
	}
	public void setHeader(int header) {
		this.header = header;
	}
	public int getSubheader() {
		return subheader;
	}
	public void setSubheader(int subheader) {
		this.subheader = subheader;
	}
	public int getAdditionalnotes() {
		return additionalnotes;
	}
	public void setAdditionalnotes(int additionalnotes) {
		this.additionalnotes = additionalnotes;
	}
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}
