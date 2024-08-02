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
@Table( name = "ScoreCard")
public class ScoreCard {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;
	
	@Column(name = "Audit_Id")
	private long Audit_Id;
	
	@Column(name = "Max_Score")
	private int Max_Score;
	
	@Column(name = "Obtained_Score")
	private int Obtained_Score;
	
	@Column(name = "Number_NC")
	private int Number_NC;

	public long getCounter() {
		return Counter;
	}

	public void setCounter(long counter) {
		Counter = counter;
	}

	public long getAudit_Id() {
		return Audit_Id;
	}

	public void setAudit_Id(long audit_Id) {
		Audit_Id = audit_Id;
	}

	public int getMax_Score() {
		return Max_Score;
	}

	public void setMax_Score(int max_Score) {
		Max_Score = max_Score;
	}

	public int getObtained_Score() {
		return Obtained_Score;
	}

	public void setObtained_Score(int obtained_Score) {
		Obtained_Score = obtained_Score;
	}

	public int getNumber_NC() {
		return Number_NC;
	}

	public void setNumber_NC(int number_NC) {
		Number_NC = number_NC;
	}
}
