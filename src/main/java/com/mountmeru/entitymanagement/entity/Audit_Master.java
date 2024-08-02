package com.mountmeru.entitymanagement.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Data
@Entity
@Table( name = "Audit_Master")
public class Audit_Master {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;
	
	@Column(name = "CreatedTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
	private Date CreatedTS;
	
	@Column(name = "UpdatedTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
	private Date UpdatedTS;
	
	@Column(name = "CreatedBy")
	private long CreatedBy;
	
	@Column(name = "UpdatedBy")
	private long UpdatedBy;
	
	@Column(name = "StationCode")
	private String StationCode;
	
	
	@Column(name = "Id")
	private long Id;
	
	@Column(name = "Type")
	private String Type;
	
	@Column(name = "State" )
	private String State;
	
	@Column ( name="Auditor")
	private long Auditor;	
	
	@Column ( name="Witness")
	private long Witness;	
	
	@Column ( name="Status")
	private String Status;
	
	@Column ( name="StartTime")
	private Date StartTime;	
	
	@Column ( name="EndTime")
	private Date EndTime;	
	
	@Column ( name="Auditor_Signature")
	private String Auditor_Signature;	
	
	@Column ( name="Witness_Signature")
	private String Witness_Signature;	
	
	@Column ( name="Remarks")
	private String Remarks;	
	
	@Column ( name="Doc_Submitted_FileName")
	private String Doc_Submitted_FileName;	
	
	@Column ( name="Doc_Submitted_FilePath")
	private String Doc_Submitted_FilePath;
	

	@Column ( name="Doc_Uploaded_FileName")
	private String Doc_Uploaded_FileName;

	@Column ( name="Doc_Uploaded_FilePath")
	private String Doc_Uploaded_FilePath;
	
	@Column ( name="Scheduled_Date")
	private Date Scheduled_Date;	

	@Column ( name="Audit_Group")
	private String Group;	
	

	public String getGroup() {
		return Group;
	}

	public void setGroup(String group) {
		Group = group;
	}

	public Date getScheduled_Date() {
		return Scheduled_Date;
	}

	public void setScheduled_Date(Date scheduled_Date) {
		Scheduled_Date = scheduled_Date;
	}

	public long getCounter() {
		return Counter;
	}

	public void setCounter(long counter) {
		Counter = counter;
	}

	public Date getCreatedTS() {
		return CreatedTS;
	}

	public void setCreatedTS(Date createdTS) {
		CreatedTS = createdTS;
	}

	public Date getUpdatedTS() {
		return UpdatedTS;
	}

	public void setUpdatedTS(Date updatedTS) {
		UpdatedTS = updatedTS;
	}

	public long getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(long createdBy) {
		CreatedBy = createdBy;
	}

	public long getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		UpdatedBy = updatedBy;
	}

	public String getStationCode() {
		return StationCode;
	}

	public void setStationCode(String stationCode) {
		StationCode = stationCode;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public long getAuditor() {
		return Auditor;
	}

	public void setAuditor(long auditor) {
		Auditor = auditor;
	}

	public long getWitness() {
		return Witness;
	}

	public void setWitness(long witness) {
		Witness = witness;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	public Date getEndTime() {
		return EndTime;
	}

	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	public String getAuditor_Signature() {
		return Auditor_Signature;
	}

	public void setAuditor_Signature(String auditor_Signature) {
		Auditor_Signature = auditor_Signature;
	}

	public String getWitness_Signature() {
		return Witness_Signature;
	}

	public void setWitness_Signature(String witness_Signature) {
		Witness_Signature = witness_Signature;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getDoc_Submitted_FileName() {
		return Doc_Submitted_FileName;
	}

	public void setDoc_Submitted_FileName(String doc_Submitted_FileName) {
		Doc_Submitted_FileName = doc_Submitted_FileName;
	}

	public String getDoc_Submitted_FilePath() {
		return Doc_Submitted_FilePath;
	}

	public void setDoc_Submitted_FilePath(String doc_Submitted_FilePath) {
		Doc_Submitted_FilePath = doc_Submitted_FilePath;
	}

	public String getDoc_Uploaded_FileName() {
		return Doc_Uploaded_FileName;
	}

	public void setDoc_Uploaded_FileName(String doc_Uploaded_FileName) {
		Doc_Uploaded_FileName = doc_Uploaded_FileName;
	}

	public String getDoc_Uploaded_FilePath() {
		return Doc_Uploaded_FilePath;
	}

	public void setDoc_Uploaded_FilePath(String doc_Uploaded_FilePath) {
		Doc_Uploaded_FilePath = doc_Uploaded_FilePath;
	}

	
}
