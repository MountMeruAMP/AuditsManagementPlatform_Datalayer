package com.mountmeru.entitymanagement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Audit_MasterDTO {
	private long counter;
	private Date createdts;
	private Date updatedts;
	private long createdby;
	private long updatedby;
	private String stationcode;
	private long id;
	private String type;
	private String state;
	private long auditor;
	private long witness;
	private String status;
	private Date starttime;
	private Date endtime;
	private String auditor_signature;
	private String witness_signature;
	private String remarks;
	private String doc_submitted_filename;
	private String doc_submitted_filepath;
	private String doc_uploaded_filename;
	private String doc_uploaded_filepath;
	private Date scheduled_date;
	private String group;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Date getScheduled_date() {
		return scheduled_date;
	}
	public void setScheduled_date(Date scheduled_date) {
		this.scheduled_date = scheduled_date;
	}
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
	public String getStationcode() {
		return stationcode;
	}
	public void setStationcode(String stationcode) {
		this.stationcode = stationcode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getAuditor() {
		return auditor;
	}
	public void setAuditor(long auditor) {
		this.auditor = auditor;
	}
	public long getWitness() {
		return witness;
	}
	public void setWitness(long witness) {
		this.witness = witness;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getAuditor_signature() {
		return auditor_signature;
	}
	public void setAuditor_signature(String auditor_signature) {
		this.auditor_signature = auditor_signature;
	}
	public String getWitness_signature() {
		return witness_signature;
	}
	public void setWitness_signature(String witness_signature) {
		this.witness_signature = witness_signature;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDoc_submitted_filename() {
		return doc_submitted_filename;
	}
	public void setDoc_submitted_filename(String doc_submitted_filename) {
		this.doc_submitted_filename = doc_submitted_filename;
	}
	public String getDoc_submitted_filepath() {
		return doc_submitted_filepath;
	}
	public void setDoc_submitted_filepath(String doc_submitted_filepath) {
		this.doc_submitted_filepath = doc_submitted_filepath;
	}
	public String getDoc_uploaded_filename() {
		return doc_uploaded_filename;
	}
	public void setDoc_uploaded_filename(String doc_uploaded_filename) {
		this.doc_uploaded_filename = doc_uploaded_filename;
	}
	public String getDoc_uploaded_filepath() {
		return doc_uploaded_filepath;
	}
	public void setDoc_uploaded_filepath(String doc_uploaded_filepath) {
		this.doc_uploaded_filepath = doc_uploaded_filepath;
	}	
}
