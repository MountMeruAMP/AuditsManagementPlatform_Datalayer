package com.mountmeru.entitymanagement.jsonresponses;

import lombok.Data;

@Data
public class UpcomingAuditsTable {
	private String auditid; // Internal Value
	private String stationname;
	private String audittype; // Internal Value
	private String auditname; // For display only.
	private String duedate;
	private String lastauditdate;
	public String getAuditid() {
		return auditid;
	}
	public void setAuditid(String auditid) {
		this.auditid = auditid;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public String getAudittype() {
		return audittype;
	}
	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}
	public String getAuditname() {
		return auditname;
	}
	public void setAuditname(String auditname) {
		this.auditname = auditname;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getLastauditdate() {
		return lastauditdate;
	}
	public void setLastauditdate(String lastauditdate) {
		this.lastauditdate = lastauditdate;
	}
}
