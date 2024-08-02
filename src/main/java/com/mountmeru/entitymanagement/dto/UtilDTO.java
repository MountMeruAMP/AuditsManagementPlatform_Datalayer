package com.mountmeru.entitymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UtilDTO {
	private long counter;
	public long getCounter() {
		return counter;
	}
	public void setCounter(long counter) {
		this.counter = counter;
	}
	private long createdby;
	private String type;
	private String value;
	private String placeholder_1;
	private String placeholder_2;
	private String placeholder_3;
	public long getCreatedby() {
		return createdby;
	}
	public void setCreatedby(long createdby) {
		this.createdby = createdby;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPlaceholder_1() {
		return placeholder_1;
	}
	public void setPlaceholder_1(String placeholder_1) {
		this.placeholder_1 = placeholder_1;
	}
	public String getPlaceholder_2() {
		return placeholder_2;
	}
	public void setPlaceholder_2(String placeholder_2) {
		this.placeholder_2 = placeholder_2;
	}
	public String getPlaceholder_3() {
		return placeholder_3;
	}
	public void setPlaceholder_3(String placeholder_3) {
		this.placeholder_3 = placeholder_3;
	}
}
