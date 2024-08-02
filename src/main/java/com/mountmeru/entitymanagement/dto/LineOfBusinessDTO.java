package com.mountmeru.entitymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor


@Data
public class LineOfBusinessDTO {
	private long counter;
	private String lobcode;
	private String lob_name;
	private String lob_shortname;
	private long manager_id;
	private String status;
	public long getCounter() {
		return counter;
	}
	public void setCounter(long counter) {
		this.counter = counter;
	}
	public String getLobcode() {
		return lobcode;
	}
	public void setLobcode(String lobcode) {
		this.lobcode = lobcode;
	}
	public String getLob_name() {
		return lob_name;
	}
	public void setLob_name(String lob_name) {
		this.lob_name = lob_name;
	}
	public String getLob_shortname() {
		return lob_shortname;
	}
	public void setLob_shortname(String lob_shortname) {
		this.lob_shortname = lob_shortname;
	}
	public long getManager_id() {
		return manager_id;
	}
	public void setManager_id(long manager_id) {
		this.manager_id = manager_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
