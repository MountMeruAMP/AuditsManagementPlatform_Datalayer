package com.mountmeru.entitymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.ERB_Audit_StagingDTO;

@Service
public interface ERB_Audit_StagingService {
	List<ERB_Audit_StagingDTO> createERBAuditStaging(ERB_Audit_StagingDTO dto, long loginUserId);
	List<ERB_Audit_StagingDTO> updateERBAuditStaging(List<ERB_Audit_StagingDTO> dto, long loginUserId);
}
