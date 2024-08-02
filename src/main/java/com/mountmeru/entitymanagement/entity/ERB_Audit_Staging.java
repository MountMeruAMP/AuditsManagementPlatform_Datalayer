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
@Table( name = "ERB_Audit_Staging")
public class ERB_Audit_Staging {
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
	
	@Column(name = "Comments")
	private String Comments;
	
	
	@Column(name = "PIC_Submitted_FileName")
	private String PIC_Submitted_FileName;
	

	@Column(name = "PIC_Submitted_FilePath")
	private String PIC_Submitted_FilePath;


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


	public String getComments() {
		return Comments;
	}


	public void setComments(String comments) {
		Comments = comments;
	}


	public String getPIC_Submitted_FileName() {
		return PIC_Submitted_FileName;
	}


	public void setPIC_Submitted_FileName(String pIC_Submitted_FileName) {
		PIC_Submitted_FileName = pIC_Submitted_FileName;
	}


	public String getPIC_Submitted_FilePath() {
		return PIC_Submitted_FilePath;
	}


	public void setPIC_Submitted_FilePath(String pIC_Submitted_FilePath) {
		PIC_Submitted_FilePath = pIC_Submitted_FilePath;
	}	
}
