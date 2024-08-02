package com.mountmeru.entitymanagement.jsonresponses;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor

@Data
public class ERB_Audit_ScorecardSplitter {
	private String sectiontype;
	private String sectionname;
	private String nctotal;
	private String ncpercent;
	private String maxscore;
	private String obtainedscore;
	private String obtainedpercent;
	private String grade;
	
	
	
	public String getSectiontype() {
		return sectiontype;
	}
	public void setSectiontype(String sectiontype) {
		this.sectiontype = sectiontype;
	}
	public String getSectionname() {
		return sectionname;
	}
	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}
	public String getNctotal() {
		return nctotal;
	}
	public void setNctotal(String nctotal) {
		this.nctotal = nctotal;
	}
	public String getNcpercent() {
		return ncpercent;
	}
	public void setNcpercent(String ncpercent) {
		this.ncpercent = ncpercent;
	}
	public String getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(String maxscore) {
		this.maxscore = maxscore;
	}
	public String getObtainedscore() {
		return obtainedscore;
	}
	public void setObtainedscore(String obtainedscore) {
		this.obtainedscore = obtainedscore;
	}
	public String getObtainedpercent() {
		return obtainedpercent;
	}
	public void setObtainedpercent(String obtainedpercent) {
		this.obtainedpercent = obtainedpercent;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
