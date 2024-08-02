package com.mountmeru.entitymanagement.jsonresponses;

import com.mountmeru.entitymanagement.dto.ERB_Audit_MappingDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ERB_Audit_Initial_LoadDataResponse {
	private ERB_Audit_MappingDTO oERB_Audit_MappingDTO;
	private String savedscore;
	private String savedremark;
	private String savedcomment;
	public ERB_Audit_MappingDTO getoERB_Audit_MappingDTO() {
		return oERB_Audit_MappingDTO;
	}
	public void setoERB_Audit_MappingDTO(ERB_Audit_MappingDTO oERB_Audit_MappingDTO) {
		this.oERB_Audit_MappingDTO = oERB_Audit_MappingDTO;
	}
	public String getSavedscore() {
		return savedscore;
	}
	public void setSavedscore(String savedscore) {
		this.savedscore = savedscore;
	}
	public String getSavedremark() {
		return savedremark;
	}
	public void setSavedremark(String savedremark) {
		this.savedremark = savedremark;
	}
	public String getSavedcomment() {
		return savedcomment;
	}
	public void setSavedcomment(String savedcomment) {
		this.savedcomment = savedcomment;
	}
}
