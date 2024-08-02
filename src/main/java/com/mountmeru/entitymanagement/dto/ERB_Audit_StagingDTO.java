package com.mountmeru.entitymanagement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@AllArgsConstructor
@Data
public class ERB_Audit_StagingDTO {
	private long counter;
	private Date createdts;
	private Date updatedts;
	private long createdby;
	private long updatedby;
	private long audit_id;
	private int totalscore;	
	private int header;	
	private int subheader;	
	private int additionalnotes;	
	private int question;
	private int obtained_score;
	private String remarks;
	private String comments;
	private String pic_submitted_filename;
	private String pic_submitted_filepath;
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
	public int getTotalscore() {
		return totalscore;
	}
	public void setTotalscore(int totalscore) {
		this.totalscore = totalscore;
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getPic_submitted_filename() {
		return pic_submitted_filename;
	}
	public void setPic_submitted_filename(String pic_submitted_filename) {
		this.pic_submitted_filename = pic_submitted_filename;
	}
	public String getPic_submitted_filepath() {
		return pic_submitted_filepath;
	}
	public void setPic_submitted_filepath(String pic_submitted_filepath) {
		this.pic_submitted_filepath = pic_submitted_filepath;
	}
}
