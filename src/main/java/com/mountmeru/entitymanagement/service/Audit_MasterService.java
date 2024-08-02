package com.mountmeru.entitymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.Audit_MasterDTO;
import com.mountmeru.entitymanagement.entity.Audit_Master;
import com.mountmeru.entitymanagement.jsonresponses.CompletedAuditResponse;
import com.mountmeru.entitymanagement.jsonresponses.UpcomingAuditsResponse;

@Service
public interface Audit_MasterService {
	Audit_MasterDTO startAudit(Audit_MasterDTO auditMasterDTO, long loginUserId);
	Audit_MasterDTO createAuditMaster(Audit_MasterDTO auditMasterDTO, long loginUserId);
	Audit_MasterDTO updateAuditMaster(Audit_MasterDTO auditMasterDTO, long loginUserId);
	Audit_MasterDTO submitAudit(Audit_MasterDTO auditMasterDTO, long loginUserId);
	Audit_MasterDTO uploadFinalAuditDocuments(Audit_MasterDTO auditMasterDTO, long loginUserId); 
	Audit_Master getAuditMasterByAuditId(long auditId);	
	UpcomingAuditsResponse getAllUpComingAudits(long loginUserId);
	List<Audit_MasterDTO> getAllPendingAudits(long loginUserId);
	CompletedAuditResponse getAllCompletedAudits(long loginUserId, String fromDate, String toDate);
	List<Audit_MasterDTO> getCompletedAudits(long loginUserId, int days);
}
