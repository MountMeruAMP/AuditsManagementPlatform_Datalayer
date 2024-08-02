package com.mountmeru.entitymanagement.jsonresponses;

import lombok.Data;

@Data
public class CompletedAuditsTable {
    private String auditid; // Internal Value
    private String stationname;
    private String audittype; // Internal Value
    private String auditname; // For display only.
    private String duedate;
    private String lastauditdate;
    private String starttime;
    private String stationcode;
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
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getStationcode() {
		return stationcode;
	}
	public void setStationcode(String stationcode) {
		this.stationcode = stationcode;
	}
}