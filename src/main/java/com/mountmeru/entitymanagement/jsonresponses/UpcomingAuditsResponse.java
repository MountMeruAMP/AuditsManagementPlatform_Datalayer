package com.mountmeru.entitymanagement.jsonresponses;

import java.util.List;

import lombok.Data;

@Data
public class UpcomingAuditsResponse {
	private String pendingaudits;	
	private String numberofaudits;
	private List<UpcomingAuditsTable> tabledata;
	
	
	public String getPendingaudits() {
		return pendingaudits;
	}
	public void setPendingaudits(String pendingaudits) {
		this.pendingaudits = pendingaudits;
	}
	
	public String getNumberofaudits() {
		return numberofaudits;
	}
	public void setNumberofaudits(String numberofaudits) {
		this.numberofaudits = numberofaudits;
	}	
	public List<UpcomingAuditsTable> getListUpcomingAuditsTableDTO() {
		return tabledata;
	}
	public void setListUpcomingAuditsTableDTO(List<UpcomingAuditsTable> listUpcomingAuditsTableDTO) {
		this.tabledata = listUpcomingAuditsTableDTO;
	}
}
