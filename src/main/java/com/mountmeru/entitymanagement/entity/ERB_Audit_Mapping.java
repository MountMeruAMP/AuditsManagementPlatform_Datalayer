package com.mountmeru.entitymanagement.entity;

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
@Table( name = "ERB_Audit_Mapping")
public class ERB_Audit_Mapping {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;	
	
	@Column(name = "CreatedBy")
	private long CreatedBy;
	
	@Column(name = "Audit_Type")
	private String Audit_Type;
	
	@Column(name = "Header")
	private int Header;
	
	@Column(name = "Sub_Header")
	private int Sub_Header;
	
	@Column(name = "Additional_Notes")
	private int Additional_Notes;
	
	@Column(name = "Question")
	private int Question;
	
	@Column(name = "Question_Text")
	private String Description;
	
	@Column(name = "Points")
	private int Points;

	public int getPoints() {
		return Points;
	}

	public void setPoints(int points) {
		Points = points;
	}

	// Getters and Setters Methods
	public long getCounter() {
		return Counter;
	}

	public void setCounter(long counter) {
		Counter = counter;
	}

	public long getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(long createdBy) {
		CreatedBy = createdBy;
	}

	public String getAudit_Type() {
		return Audit_Type;
	}

	public void setAudit_Type(String audit_Type) {
		Audit_Type = audit_Type;
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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}
