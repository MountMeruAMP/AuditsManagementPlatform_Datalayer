package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.Audit_MasterDTO;
import com.mountmeru.entitymanagement.entity.Audit_Master;

@Service
public class Audit_MasterMapper {
	public static Audit_Master mapToObject(Audit_MasterDTO auditDTO)
	{
		Audit_Master auditMaster = new Audit_Master(
				auditDTO.getCounter(),
				auditDTO.getCreatedts(),
				auditDTO.getUpdatedts(),
				auditDTO.getCreatedby(),
				auditDTO.getUpdatedby(),
				auditDTO.getStationcode(),
				auditDTO.getId(), 
				auditDTO.getType(),
				auditDTO.getState(),
				auditDTO.getAuditor(),
				auditDTO.getWitness(),
				auditDTO.getStatus(),
				auditDTO.getStarttime(),
				auditDTO.getEndtime(),
				auditDTO.getAuditor_signature(),
				auditDTO.getWitness_signature(),
				auditDTO.getRemarks(), 
				auditDTO.getDoc_submitted_filename(),
				auditDTO.getDoc_submitted_filepath(),
				auditDTO.getDoc_uploaded_filename(), 
				auditDTO.getDoc_uploaded_filepath(),
				auditDTO.getScheduled_date(),
				auditDTO.getGroup()
				);
		return auditMaster;
	}	
	
	public static Audit_MasterDTO maptoDTO(Audit_Master audit)
	{
		Audit_MasterDTO auditmasterDTO = new Audit_MasterDTO(				
				audit.getCounter(),
				audit.getCreatedTS(),
				audit.getUpdatedTS(),
				audit.getCreatedBy(),
				audit.getUpdatedBy(),
				audit.getStationCode(),
				audit.getId(), 
				audit.getType(),
				audit.getState(), 
				audit.getAuditor(),
				audit.getWitness(),
				audit.getStatus(),
				audit.getStartTime(),
				audit.getEndTime(),
				audit.getAuditor_Signature(),
				audit.getWitness_Signature(),
				audit.getRemarks(), 
				audit.getDoc_Submitted_FileName(),
				audit.getDoc_Submitted_FilePath(),
				audit.getDoc_Uploaded_FileName(), 
				audit.getDoc_Uploaded_FilePath(),
				audit.getScheduled_Date(),
				audit.getGroup()
				);		
		return auditmasterDTO;
	}
}
