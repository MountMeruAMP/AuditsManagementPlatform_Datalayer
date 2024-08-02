package com.mountmeru.entitymanagement.mapper;

import com.mountmeru.entitymanagement.dto.ERB_Audit_StagingDTO;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Staging;

public class ERB_Audit_StagingMapper {
	public static ERB_Audit_Staging mapToObject(ERB_Audit_StagingDTO dto)
	{
		ERB_Audit_Staging obj = new ERB_Audit_Staging(
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
	public static ERB_Audit_StagingDTO maptoDTO(ERB_Audit_Staging obj)
	{
		ERB_Audit_StagingDTO dto = new ERB_Audit_StagingDTO(
				obj.getCounter(), 
				obj.getCreatedTS(),
				obj.getUpdatedTS(),
				obj.getCreatedBy(),
				obj.getUpdatedBy(),
				obj.getAudit_Id(),
				obj.getTotal_Score(),				
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
