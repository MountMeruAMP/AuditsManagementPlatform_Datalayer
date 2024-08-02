package com.mountmeru.entitymanagement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ERB_Audit_Non_ComplianceDTO {

	private long counter;
	private Date createdts;
	private Date updatedts;
	private long createdby;
	private long updatedby;	
	private long audit_id;
	private long id;
	private long totalscore;	
	private int header;
	private int subsection;
	private int question;
	private int obtained_score;
	private String remarks;
	private String imagefile_name;
	private String imagefile_path;
	private String state;
	private String zoho_ticket_number;
	private long zoho_ticket_assignedto;
	public long getCounter() {
		return counter;
	}
	public void setCounter(long counter) {
		this.counter = counter;
	}
	public Date getCreatedts() {
		return createdts;
	}
	public void setCreatedts(Date createdts) {
		this.createdts = createdts;
	}
	public Date getUpdatedts() {
		return updatedts;
	}
	public void setUpdatedts(Date updatedts) {
		this.updatedts = updatedts;
	}
	public long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}
	public long getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(long updatedby) {
		this.updatedby = updatedby;
	}
	public long getAudit_id() {
		return audit_id;
	}
	public void setAudit_id(long audit_id) {
		this.audit_id = audit_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getHeader() {
		return header;
	}
	public void setHeader(int header) {
		this.header = header;
	}
	public int getSection() {
		return subsection;
	}
	public void setSection(int section) {
		this.subsection = section;
	}
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	public int getObtained_score() {
		return obtained_score;
	}
	public void setObtained_score(int obtained_score) {
		this.obtained_score = obtained_score;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getImagefile_name() {
		return imagefile_name;
	}
	public void setImagefile_name(String imagefile_name) {
		this.imagefile_name = imagefile_name;
	}
	public String getImagefile_path() {
		return imagefile_path;
	}
	public void setImagefile_path(String imagefile_path) {
		this.imagefile_path = imagefile_path;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZoho_ticket_number() {
		return zoho_ticket_number;
	}
	public void setZoho_ticket_number(String zoho_ticket_number) {
		this.zoho_ticket_number = zoho_ticket_number;
	}
	public long getZoho_ticket_assignedto() {
		return zoho_ticket_assignedto;
	}
	public void setZoho_ticket_assignedto(long zoho_ticket_assignedto) {
		this.zoho_ticket_assignedto = zoho_ticket_assignedto;
	}
	public long getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(long totalscore) {
		this.totalscore = totalscore;
	}
}
