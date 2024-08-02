package com.mountmeru.entitymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.ERB_Audit_MappingDTO;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Mapping;
import com.mountmeru.entitymanagement.jsonresponses.ERB_Audit_Initial_LoadResponse;

@Service
public interface ERB_Audit_MappingService { 
	List<ERB_Audit_MappingDTO> getAllQuestionsForAudit(String strAuditType);
	ERB_Audit_Initial_LoadResponse getAllRequiredDataForERBAudit(long auditId);
	List<ERB_Audit_Mapping> getRecordsByHeaderSubHeaderAddInfoQuestions(String strAuditType, int header, int subheader, int addnotes, int question);
	List<ERB_Audit_Mapping> getRecordsByHeaderSubHeaderAddInfoNotQuestions(String strAuditType, int header, int subheader, int addnotes, int question);
	
	List<ERB_Audit_Mapping> getRecordsByHeaderNotSubHeaderNotQuestions(String strAuditType, int header, int subheader, int addnotes, int question);
	
}
