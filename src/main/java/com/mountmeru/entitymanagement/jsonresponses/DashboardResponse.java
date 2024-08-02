package com.mountmeru.entitymanagement.jsonresponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {

    private CompletedAuditResponse completedAuditResponse;
    private UpcomingAuditsResponse upcomingAuditsResponse;
    private AuditScoreSummary auditScoreSummary;
    private CommonResponse topPerformanceStationResponse;
    private CommonResponse bottomPerformanceStationResponse;
	public CompletedAuditResponse getCompletedAuditResponse() { 
		return completedAuditResponse;
	}
	public void setCompletedAuditResponse(CompletedAuditResponse completedAuditResponse) {
		this.completedAuditResponse = completedAuditResponse;
	}
	public UpcomingAuditsResponse getUpcomingAuditsResponse() {
		return upcomingAuditsResponse;
	}
	public void setUpcomingAuditsResponse(UpcomingAuditsResponse upcomingAuditsResponse) {
		this.upcomingAuditsResponse = upcomingAuditsResponse;
	}
	public AuditScoreSummary getAuditScoreSummary() {
		return auditScoreSummary;
	}
	public void setAuditScoreSummary(AuditScoreSummary auditScoreSummary) {
		this.auditScoreSummary = auditScoreSummary;
	}
	public CommonResponse getTopPerformanceStationResponse() { 
		return topPerformanceStationResponse;
	}
	public void setTopPerformanceStationResponse(CommonResponse topPerformanceStationResponse) {
		this.topPerformanceStationResponse = topPerformanceStationResponse;
	}
	public CommonResponse getBottomPerformanceStationResponse() {
		return bottomPerformanceStationResponse;
	}
	public void setBottomPerformanceStationResponse(CommonResponse bottomPerformanceStationResponse) {
		this.bottomPerformanceStationResponse = bottomPerformanceStationResponse;
	}
    

}