package com.mountmeru.entitymanagement.service;

import com.mountmeru.entitymanagement.dto.Audit_MasterDTO;
import com.mountmeru.entitymanagement.jsonresponses.AuditScoreSummary;
import com.mountmeru.entitymanagement.jsonresponses.CommonResponse;
import com.mountmeru.entitymanagement.jsonresponses.DashboardResponse;

import java.util.List;

public interface DashboardService {
    List<Audit_MasterDTO> getUpcomingAudits(long loginUserId);
    List<Audit_MasterDTO> getCompletedAudits(long loginUserId);
    AuditScoreSummary getClusterAvgScore(long loginUserId, Integer days);
    CommonResponse getStationPerformanceByAvgScore(long loginUserId, Integer days, String sort);
    DashboardResponse getDashboardData(long loginUserId);
}