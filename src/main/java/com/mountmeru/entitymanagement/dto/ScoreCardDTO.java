package com.mountmeru.entitymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ScoreCardDTO {

	private long counter;
	private long audit_id;
	private int max_score;
	private int obtained_score;
	private int number_nc;
	
	public long getCounter() {
		return counter;
	}
	public void setCounter(long counter) {
		this.counter = counter;
	}
	public long getAudit_id() {
		return audit_id;
	}
	public void setAudit_id(long audit_id) {
		this.audit_id = audit_id;
	}
	public int getMax_score() {
		return max_score;
	}
	public void setMax_score(int max_score) {
		this.max_score = max_score;
	}
	public int getObtained_score() {
		return obtained_score;
	}
	public void setObtained_score(int obtained_score) {
		this.obtained_score = obtained_score;
	}
	public int getNumber_nc() {
		return number_nc;
	}
	public void setNumber_nc(int number_nc) {
		this.number_nc = number_nc;
	}
}
