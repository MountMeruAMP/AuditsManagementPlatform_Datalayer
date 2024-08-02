package com.mountmeru.entitymanagement.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.ScoreCardDTO;
import com.mountmeru.entitymanagement.dto.projection.AuditScoreProjection;
import com.mountmeru.entitymanagement.jsonresponses.AuditScoreSummary;
import com.mountmeru.entitymanagement.jsonresponses.ERB_Audit_ScoreCardResponse;

@Service
public interface ScorecardService {
	ERB_Audit_ScoreCardResponse getERBConsumerAuditScoreCard(long audit_id, long loginUserId );
	List<ScoreCardDTO> getAllScoreCardByAuditIds(List<Long> auditIds);
	Optional<AuditScoreSummary> getAuditScoreSummary(List<Long> auditIds);
	List<AuditScoreProjection> getAllScoreCardByStations(long loginUserId, Date startDate);
}
 