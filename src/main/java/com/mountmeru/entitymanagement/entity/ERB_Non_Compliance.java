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
@Table( name = "ERB_Non_Compliance")
public class ERB_Non_Compliance {
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
	
	@Column(name = "Audit_Id")
	private long Audit_Id;	

	@Column(name = "Total_Score")
	private int Total_Score;
	
	@Column(name = "Header")
	private int Header;
	
	@Column(name = "Sub_Header")
	private int Sub_Header;
	
	@Column(name = "Additional_Notes")
	private int Additional_Notes;
	
	@Column(name = "Question")
	private int Question;
	
	@Column(name = "Obtained_Score")
	private int Obtained_Score;
	
	@Column(name = "Remarks")
	private String Remarks;
	
	@Column(name = "Imagefile_Name")
	private String Imagefile_Name;
	
	@Column(name = "Imagefile_Path")
	private String Imagefile_Path;
	
	@Column(name = "State")
	private String State;
	
	@Column(name = "Zoho_Ticket_Number")
	private String Zoho_Ticket_Number;
	
	@Column(name = "Zoho_Ticket_AssignedTo")
	private long Zoho_Ticket_AssignedTo;

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

	public long getAudit_Id() {
		return Audit_Id;
	}

	public void setAudit_Id(long audit_Id) {
		Audit_Id = audit_Id;
	}

	public int getTotal_Score() {
		return Total_Score;
	}

	public void setTotal_Score(int total_Score) {
		Total_Score = total_Score;
	}

	public int getHeader() {
		return Header;
	}

	public void setHeader(int header) {
		Header = header;
	}

	public int getSub_Header() {
		return Sub_Header;
	}

	public void setSub_Header(int sub_Header) {
		Sub_Header = sub_Header;
	}

	public int getAdditional_Notes() {
		return Additional_Notes;
	}

	public void setAdditional_Notes(int additional_Notes) {
		Additional_Notes = additional_Notes;
	}

	public int getQuestion() {
		return Question;
	}

	public void setQuestion(int question) {
		Question = question;
	}

	public int getObtained_Score() {
		return Obtained_Score;
	}

	public void setObtained_Score(int obtained_Score) {
		Obtained_Score = obtained_Score;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getImagefile_Name() {
		return Imagefile_Name;
	}

	public void setImagefile_Name(String imagefile_Name) {
		Imagefile_Name = imagefile_Name;
	}

	public String getImagefile_Path() {
		return Imagefile_Path;
	}

	public void setImagefile_Path(String imagefile_Path) {
		Imagefile_Path = imagefile_Path;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZoho_Ticket_Number() {
		return Zoho_Ticket_Number;
	}

	public void setZoho_Ticket_Number(String zoho_Ticket_Number) {
		Zoho_Ticket_Number = zoho_Ticket_Number;
	}

	public long getZoho_Ticket_AssignedTo() {
		return Zoho_Ticket_AssignedTo;
	}

	public void setZoho_Ticket_AssignedTo(long zoho_Ticket_AssignedTo) {
		Zoho_Ticket_AssignedTo = zoho_Ticket_AssignedTo;
	}
}
