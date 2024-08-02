package com.mountmeru.entitymanagement.jsonresponses;

import java.util.List;

import com.mountmeru.entitymanagement.dto.Audit_MasterDTO;
import com.mountmeru.entitymanagement.dto.ERB_Audit_MappingDTO;
import com.mountmeru.entitymanagement.dto.UtilDTO;

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
public class ERB_Audit_Initial_LoadResponse {
	private Audit_MasterDTO auditdetails;
	List<ERB_Audit_Initial_LoadDataResponse> questions;	
	private List<UtilDTO> selection;
	private String latitude;
	private String longitude;
	private String transaction;
	
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public List<ERB_Audit_Initial_LoadDataResponse> getListERB_Audit_MappingDTO() {
		return questions;
	}
	public void setListERB_Audit_MappingDTO(List<ERB_Audit_Initial_LoadDataResponse> listERB_Audit_MappingDTO) {
		this.questions = listERB_Audit_MappingDTO;
	}
	public List<UtilDTO> getListUtilDTO() { 
		return selection;
	}
	public void setListUtilDTO(List<UtilDTO> listUtilDTO) {
		this.selection = listUtilDTO;
	}
	public Audit_MasterDTO getoAudit_MasterDTO() {
		return auditdetails;
	}
	public void setoAudit_MasterDTO(Audit_MasterDTO oAudit_MasterDTO) {
		this.auditdetails = oAudit_MasterDTO;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
