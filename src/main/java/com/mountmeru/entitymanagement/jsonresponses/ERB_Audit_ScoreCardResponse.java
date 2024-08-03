package com.mountmeru.entitymanagement.jsonresponses;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ERB_Audit_ScoreCardResponse {	
	private String heading;
	private String evolscoresummary;
	private String cumusummary;
	private String audit_id;
	private String stationcode;	
	private String stationname;
	private String stationtype;
	private String stationmanagerid;
	private String staymanagername;
	private String regionheadid;
	private String regionheadname;	
	private String auditdate;
	private String clustermanagerid;
	private String clustermanagername;
	private String auditorid;
	private String auditorname;	
	private String auditstarttime;
	private String auditendtime;	
	private String overallgrade;
	private String remarks;
	private List<ERB_Audit_ScorecardSplitter> header;	
	private List<ERB_Audit_ScorecardSplitter> subheader;
	private List<ERB_Audit_ScorecardSplitter> previousscores;
	
	public String getAudit_id() {
		return audit_id;
	}
	public void setAudit_id(String audit_id) {
		this.audit_id = audit_id;
	}
	public String getStationcode() {
		return stationcode;
	}
	public void setStationcode(String stationcode) {
		this.stationcode = stationcode;
	}
	public String getStationname() {
		return stationname;
	}
	public void setStationname(String stationname) {
		this.stationname = stationname;
	}
	public String getStationtype() {
		return stationtype;
	}
	public void setStationtype(String stationtype) {
		this.stationtype = stationtype;
	}
	public String getStationmanagerid() {
		return stationmanagerid;
	}
	public void setStationmanagerid(String stationmanagerid) {
		this.stationmanagerid = stationmanagerid;
	}
	public String getStaymanagername() {
		return staymanagername;
	}
	public void setStaymanagername(String staymanagername) {
		this.staymanagername = staymanagername;
	}
	public String getRegionheadid() {
		return regionheadid;
	}
	public void setRegionheadid(String regionheadid) {
		this.regionheadid = regionheadid;
	}
	public String getRegionheadname() {
		return regionheadname;
	}
	public void setRegionheadname(String regionheadname) {
		this.regionheadname = regionheadname;
	}
	public String getAuditdate() {
		return auditdate;
	}
	public void setAuditdate(String auditdate) {
		this.auditdate = auditdate;
	}
	public String getClustermanagerid() {
		return clustermanagerid;
	}
	public void setClustermanagerid(String clustermanagerid) {
		this.clustermanagerid = clustermanagerid;
	}
	public String getClustermanagername() {
		return clustermanagername;
	}
	public void setClustermanagername(String clustermanagername) {
		this.clustermanagername = clustermanagername;
	}
	public String getAuditorid() {
		return auditorid;
	}
	public void setAuditorid(String auditorid) {
		this.auditorid = auditorid;
	}
	public String getAuditorname() {
		return auditorname;
	}
	public void setAuditorname(String auditorname) {
		this.auditorname = auditorname;
	}
	public String getAuditstarttime() {
		return auditstarttime;
	}
	public void setAuditstarttime(String auditstarttime) {
		this.auditstarttime = auditstarttime;
	}
	public String getAuditendtime() {
		return auditendtime;
	}
	public void setAuditendtime(String auditendtime) {
		this.auditendtime = auditendtime;
	}	
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getEvolscoresummary() {
		return evolscoresummary;
	}
	public void setEvolscoresummary(String evolscoresummary) {
		this.evolscoresummary = evolscoresummary;
	}
	public String getCumusummary() {
		return cumusummary;
	}
	public void setCumusummary(String cumusummary) {
		this.cumusummary = cumusummary;
	}
	public String getOverallgrade() {
		return overallgrade;
	}
	public void setOverallgrade(String overallgrade) {
		this.overallgrade = overallgrade;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<ERB_Audit_ScorecardSplitter> getHeader() {
		return header;
	}
	public void setHeader(List<ERB_Audit_ScorecardSplitter> header) {
		this.header = header;
	}
	public List<ERB_Audit_ScorecardSplitter> getSubheader() {
		return subheader;
	}
	public void setSubheader(List<ERB_Audit_ScorecardSplitter> subheader) {
		this.subheader = subheader;
	}
	public List<ERB_Audit_ScorecardSplitter> getPreviousscores() {
		return previousscores; 
	}
	public void setPreviousscores(List<ERB_Audit_ScorecardSplitter> previousscores) {
		this.previousscores = previousscores;
	}
}
