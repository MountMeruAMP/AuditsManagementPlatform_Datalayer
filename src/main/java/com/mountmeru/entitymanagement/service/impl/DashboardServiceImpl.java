package com.mountmeru.entitymanagement.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.Audit_MasterDTO;
import com.mountmeru.entitymanagement.dto.ScoreCardDTO;
import com.mountmeru.entitymanagement.dto.projection.AuditScoreProjection;
import com.mountmeru.entitymanagement.jsonresponses.AuditScoreSummary;
import com.mountmeru.entitymanagement.jsonresponses.AuditScoreSummaryStation;
import com.mountmeru.entitymanagement.jsonresponses.CommonResponse;
import com.mountmeru.entitymanagement.jsonresponses.DashboardResponse;
import com.mountmeru.entitymanagement.service.Audit_MasterService;
import com.mountmeru.entitymanagement.service.DashboardService;
import com.mountmeru.entitymanagement.service.ScorecardService;
import com.mountmeru.entitymanagement.service.UsersService;
import com.mountmeru.entitymanagement.utils.CommonUtility;
import com.mountmeru.entitymanagement.utils.Constants;

@Service
public class DashboardServiceImpl implements DashboardService {


    @Autowired
    Audit_MasterService oAudit_MasterService;

    

    @Autowired
    private UsersService oUsersService;

    @Autowired
    private ScorecardService oScorecardService;

    @Value("${application.completedaudits.days}")
    String completedauditsdays;

    @Override
    public DashboardResponse getDashboardData(long loginUserId) {
        DashboardResponse response = new DashboardResponse();
        response.setUpcomingAuditsResponse(oAudit_MasterService.getAllUpComingAudits(loginUserId));
        response.setCompletedAuditResponse(oAudit_MasterService.getAllCompletedAudits(loginUserId, null, null));
        response.setAuditScoreSummary(getClusterAvgScore(loginUserId, null));
        response.setTopPerformanceStationResponse(getStationPerformanceByAvgScore(loginUserId, null, Constants.TOP));
        response.setBottomPerformanceStationResponse(getStationPerformanceByAvgScore(loginUserId, null, Constants.BOTTOM));

        return response;
    }

    @Override
    public List<Audit_MasterDTO> getUpcomingAudits(long loginUserId) {


//        return oAudit_MasterService.getAllUpComingAudits(loginUserId, 1);
        return null;
    }

    @Override
    public List<Audit_MasterDTO> getCompletedAudits(long loginUserId) {
        return oAudit_MasterService.getCompletedAudits(loginUserId, 60);
    }

    @Override
    public AuditScoreSummary getClusterAvgScore(long loginUserId, Integer days) {
        AuditScoreSummary scoreSummary = new AuditScoreSummary();
        days = days == null ? Integer.valueOf(completedauditsdays) : days;

        Optional<String> role = oUsersService.getRoleByUserId(loginUserId);

        if (role.isPresent() && Constants.roleCM.equals(role.get())) {

            // fetching all audit details by userid and days
            List<Audit_MasterDTO> auditMasterList = oAudit_MasterService.getCompletedAudits(loginUserId, days);
            if (auditMasterList.isEmpty())
                return new AuditScoreSummary("No Audits found", loginUserId, 0, 0.0, "N/A", "N/A");

            // collecting all audit ids in single list
            List<Long> auditIds = auditMasterList.stream()
                    .map(Audit_MasterDTO::getId)
                    .toList();

            // fetching all score card details by audit ids
            List<ScoreCardDTO> scoreCardDTOList = oScorecardService.getAllScoreCardByAuditIds(auditIds);
            if (scoreCardDTOList.isEmpty()){
                return new AuditScoreSummary("No score found", loginUserId, 0, 0.0, "N/A", "N/A");
            }

            // calculating the avg score of each audit
            List<Double> avgScoreList = scoreCardDTOList.stream()
                    .map(sc -> CommonUtility.calculateAvgScore(sc.getObtained_score(), sc.getMax_score()))
                    .toList();

            // calculating the average for all scores
            double avgScore = avgScoreList.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);

            // calculating the sum of NCs in the table
            int totalNC = scoreCardDTOList.stream()
                    .map(ScoreCardDTO::getNumber_nc)
                    .mapToInt(Integer::intValue)
                    .sum();

            scoreSummary.setMessage("Overall audit score for your cluster over last " + completedauditsdays + " days");
            scoreSummary.setLoginUserId(loginUserId);
            scoreSummary.setAvgScore(avgScore);
            scoreSummary.setTotalNC(totalNC);
            scoreSummary.setGrade(CommonUtility.calculateGrade(avgScore));
            scoreSummary.setGradeValue(CommonUtility.calculateGradeValue(avgScore));

            return scoreSummary;
        }else {
            return new AuditScoreSummary("Role mismatched", loginUserId, 0, 0.0, "N/A", "N/A");
        }
    }

    // working on it
    @Override
    public CommonResponse getStationPerformanceByAvgScore(long loginUserId, Integer days, String sort) {
        List<AuditScoreSummaryStation> scoreSummaryStations = new ArrayList<>();
        days = days == null ? Integer.valueOf(completedauditsdays) : days;
        long limit = 3;

        Optional<String> role = oUsersService.getRoleByUserId(loginUserId);

        if (role.isPresent() && Constants.roleCM.equals(role.get())) {
            // Calculate the date 'n' days ago
            LocalDateTime localDateTime = LocalDateTime.now().minusDays(days);
            Date startDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

            // fetching all score card details by audit ids
            List<AuditScoreProjection> auditScoreList = oScorecardService.getAllScoreCardByStations(loginUserId, startDate);
            if (auditScoreList.isEmpty()){
                return new CommonResponse(404, "No score found", auditScoreList);
            }

            Map<String, Double> mapAvgScore = auditScoreList.stream()
                    .collect(Collectors.groupingBy(AuditScoreProjection::getStation_code,
                            Collectors.averagingDouble(ac -> CommonUtility.calculateAvgScore(ac.getObtained_score(), ac.getMax_score()))));

            mapAvgScore.forEach((k, v) -> {
                scoreSummaryStations.add(new AuditScoreSummaryStation(k,
                        v, CommonUtility.calculateGrade(v),CommonUtility.calculateGradeValue(v)));
            });

            List<AuditScoreSummaryStation> scoreSummaryStationsFinal;
            if (Constants.TOP.equals(sort)) {
                scoreSummaryStationsFinal = scoreSummaryStations.stream()
                        .sorted(Comparator.comparing(AuditScoreSummaryStation::getAvgScore).reversed())
                        .limit(limit)
                        .toList();
            } else {
                scoreSummaryStationsFinal = scoreSummaryStations.stream()
                        .sorted(Comparator.comparing(AuditScoreSummaryStation::getAvgScore))
                        .limit(limit)
                        .toList();
            }

            return new CommonResponse(200, "Success", scoreSummaryStationsFinal);

        }else {
            return new CommonResponse(404, "No score found", null);
        }
    }
}