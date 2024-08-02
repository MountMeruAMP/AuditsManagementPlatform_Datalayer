package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.entity.ERB_Audit_Final;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Staging;

@Service
public class ERB_Audit_StagingToFinalMapper {
	
	public static ERB_Audit_Final convertStagingToFinal(ERB_Audit_Staging dto)
	{		
		ERB_Audit_Final obj = new ERB_Audit_Final();
		obj.setCreatedBy(dto.getCreatedBy());
		obj.setUpdatedBy(0);
		obj.setAudit_Id(dto.getAudit_Id());
		obj.setHeader(dto.getHeader());
		obj.setSub_Header(dto.getSub_Header());
		obj.setAdditional_Notes(dto.getAdditional_Notes());
		obj.setQuestion(dto.getQuestion());
		obj.setObtained_Score(dto.getObtained_Score());
		obj.setRemarks(dto.getRemarks());
		obj.setComments(dto.getComments());
		obj.setPIC_Submitted_FileName(dto.getPIC_Submitted_FileName());
		obj.setPIC_Submitted_FilePath(dto.getPIC_Submitted_FileName());
		return obj;
	}
}
