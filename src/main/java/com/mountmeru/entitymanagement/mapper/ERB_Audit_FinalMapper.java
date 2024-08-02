package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.ERB_Audit_FinalDTO;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Final;

@Service
public class ERB_Audit_FinalMapper {

	public static ERB_Audit_Final mapToObject(ERB_Audit_FinalDTO dto)
	{
		ERB_Audit_Final obj = new ERB_Audit_Final(
				dto.getCounter(), 
				dto.getCreatedts(),
				dto.getUpdatedts(),
				dto.getCreatedby(),
				dto.getUpdatedby(),
				dto.getAudit_id(),
				dto.getTotalscore(),
				dto.getHeader(),
				dto.getSubheader(),
				dto.getAdditionalnotes(),
				dto.getQuestion(),
				dto.getObtained_score(),
				dto.getRemarks(),
				dto.getComments(),
				dto.getPic_submitted_filename(), 
				dto.getPic_submitted_filepath()
				);
		return obj;
	}	
	public static ERB_Audit_FinalDTO maptoDTO(ERB_Audit_Final obj)
	{
		ERB_Audit_FinalDTO dto = new ERB_Audit_FinalDTO(
				obj.getCounter(), 
				obj.getCreatedTS(),
				obj.getUpdatedTS(),
				obj.getCreatedBy(),
				obj.getUpdatedBy(),
				obj.getAudit_Id(),
				obj.getTotal_Points(),
				obj.getHeader(),
				obj.getSub_Header(),
				obj.getAdditional_Notes(),
				obj.getQuestion(),
				obj.getObtained_Score(),
				obj.getRemarks(),
				obj.getComments(),
				obj.getPIC_Submitted_FileName(), 
				obj.getPIC_Submitted_FilePath()				
				);		
		return dto;
	} 
}
