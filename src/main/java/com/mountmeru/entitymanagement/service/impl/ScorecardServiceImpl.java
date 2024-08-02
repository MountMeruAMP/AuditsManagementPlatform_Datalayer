package com.mountmeru.entitymanagement.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.ScoreCardDTO;
import com.mountmeru.entitymanagement.dto.StationsDTO;
import com.mountmeru.entitymanagement.dto.UtilDTO;
import com.mountmeru.entitymanagement.dto.projection.AuditScoreProjection;
import com.mountmeru.entitymanagement.entity.Audit_Master;
import com.mountmeru.entitymanagement.entity.Clusters;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Mapping;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Staging;
import com.mountmeru.entitymanagement.entity.ERB_Non_Compliance;
import com.mountmeru.entitymanagement.entity.ScoreCard;
import com.mountmeru.entitymanagement.entity.Stations;
import com.mountmeru.entitymanagement.entity.Users;
import com.mountmeru.entitymanagement.jsonresponses.AuditScoreSummary;
import com.mountmeru.entitymanagement.jsonresponses.ERB_Audit_ScoreCardResponse;
import com.mountmeru.entitymanagement.jsonresponses.ERB_Audit_ScorecardSplitter;
import com.mountmeru.entitymanagement.mapper.ScoreCardMapper;
import com.mountmeru.entitymanagement.repository.Audit_MasterRepository;
import com.mountmeru.entitymanagement.repository.ClustersRepository;
import com.mountmeru.entitymanagement.repository.ERB_Audit_StagingRepository;
import com.mountmeru.entitymanagement.repository.ERB_Non_ComplianceRepository;
import com.mountmeru.entitymanagement.repository.ScoreCardRepository;
import com.mountmeru.entitymanagement.repository.StationsRepository;
import com.mountmeru.entitymanagement.repository.UsersRepository;
import com.mountmeru.entitymanagement.service.ClustersService;
import com.mountmeru.entitymanagement.service.ERB_Audit_MappingService;
import com.mountmeru.entitymanagement.service.ScorecardService;
import com.mountmeru.entitymanagement.service.UtilService;
import com.mountmeru.entitymanagement.utils.CommonUtility;
import com.mountmeru.entitymanagement.utils.DateUtils;

@Service
public class ScorecardServiceImpl implements ScorecardService{
	@Autowired
	ERB_Audit_StagingRepository oERB_Audit_StagingRepo;	
	
	@Autowired
	ERB_Audit_MappingService oERB_Audit_MappingService; 
	
	@Autowired
	ERB_Non_ComplianceRepository oNonComplianceRepo;
	
	@Autowired
	ERB_Audit_StagingRepository oERB_Audit_StagingRepository;
	
	@Autowired
	UtilService oUtilService;
	
	@Autowired
	Audit_MasterRepository oAudit_MastRepo;
	
	@Autowired
	StationsRepository oStationRep;
	
	
	@Autowired
	UsersRepository oUsersRepository;
	
	@Autowired
	DateUtils oDateUtils;
	
	@Autowired
	ClustersRepository oClusterRep;
	
	@Autowired
	ClustersService oClustersService;
	
	@Autowired
	ScoreCardRepository oScoreCardRepository;
	
	private String overallGrade = "";
	public ERB_Audit_ScoreCardResponse getERBConsumerAuditScoreCard(long audit_id, long loginUserId) {
		ERB_Audit_ScoreCardResponse oERB_Audit_ScoreCardResponse = new ERB_Audit_ScoreCardResponse();
		Audit_Master oAudit_Master = oAudit_MastRepo.getOneByAuditId(audit_id);
		String auditType = oAudit_Master.getType();
		
		Stations oStation =  oStationRep.findStationByStationCode(oAudit_Master.getStationCode());
		Users[] oUserStnMngr = oUsersRepository.findByUserId(Long.parseLong(oStation.getManager_Id()));
		
		Clusters oClusters = oClusterRep.findClusterByClusterId(oStation.getClusterID());
		Users[] oUserClustMngr = oUsersRepository.findByUserId(Long.parseLong(oClusters.getManager_Id()));
		
		Users[] oUserAuditor = oUsersRepository.findByUserId(oAudit_Master.getAuditor());		
		
		// Top Header Data
		oERB_Audit_ScoreCardResponse.setHeading("ZAMBIA RETAIL STATION ERB CONSUMER AUDIT");
		oERB_Audit_ScoreCardResponse.setAudit_id(String.valueOf(audit_id));
		oERB_Audit_ScoreCardResponse.setStationcode(oAudit_Master.getStationCode());
		oERB_Audit_ScoreCardResponse.setStationname(oStation.getStationName());
		oERB_Audit_ScoreCardResponse.setStationtype(oStation.getStationType());
		oERB_Audit_ScoreCardResponse.setStationmanagerid(oStation.getManager_Id());
		oERB_Audit_ScoreCardResponse.setStaymanagername(oUserStnMngr[0].getLastName() + ", " + oUserStnMngr[0].getFirstName());
		oERB_Audit_ScoreCardResponse.setRegionheadid(""); // TODO implementation of regional head.
		oERB_Audit_ScoreCardResponse.setRegionheadname(""); // TODO implementation of regional head.
		oERB_Audit_ScoreCardResponse.setAuditdate(oDateUtils.convertTimeStampToDate(oAudit_Master.getStartTime(), "dd/MM/yyyy"));
		
		oERB_Audit_ScoreCardResponse.setClustermanagerid(oClusters.getManager_Id());
		oERB_Audit_ScoreCardResponse.setClustermanagername(oUserClustMngr[0].getLastName() + ", " + oUserClustMngr[0].getFirstName());
		
		oERB_Audit_ScoreCardResponse.setAuditorid(String.valueOf(oAudit_Master.getAuditor()));
		oERB_Audit_ScoreCardResponse.setClustermanagername(oUserAuditor[0].getLastName() + ", " + oUserAuditor[0].getFirstName());
		
		oERB_Audit_ScoreCardResponse.setAuditstarttime(oAudit_Master.getStartTime().toString());
		if(null != oAudit_Master.getEndTime())
		oERB_Audit_ScoreCardResponse.setAuditendtime(oAudit_Master.getEndTime().toString());
		else
			oERB_Audit_ScoreCardResponse.setAuditendtime("");
		
		oERB_Audit_ScoreCardResponse.setRemarks(oAudit_Master.getRemarks());
		
		
		// Header Level Data
		oERB_Audit_ScoreCardResponse.setEvolscoresummary("EVALUATION SCORE SUMMARY");
		List<UtilDTO> listUtilHeader = oUtilService.getAllRowsByType("SCORECARD-ERBCONA-HEADER");
		oERB_Audit_ScoreCardResponse.setListERB_Audit_ScorecardSplitter(getERBConsumerAuditScoreCardSplitterHeader(audit_id, auditType, listUtilHeader));

		
		// Sub Header Level Data.
		oERB_Audit_ScoreCardResponse.setCumusummary("CUMMULATIVE SUMMARY SECTIONWISE");
		List<UtilDTO> listUtilSubHeader = oUtilService.getAllRowsByType("SCORECARD-ERBCONA-SUBHEADER");
		oERB_Audit_ScoreCardResponse.setListERB_Audit_ScorecardSplitter(getERBConsumerAuditScoreCardSplitterSubHeader(audit_id, auditType, listUtilSubHeader));

		// Don't change the position of this code.
		oERB_Audit_ScoreCardResponse.setOverallgrade(overallGrade);
		return oERB_Audit_ScoreCardResponse;
	}	
	public List<ERB_Audit_ScorecardSplitter> getERBConsumerAuditScoreCardSplitterHeader(long audit_id, String auditType, List<UtilDTO> listUtilHeader) 
	{
		List<ERB_Audit_ScorecardSplitter> listSplitter = new LinkedList<ERB_Audit_ScorecardSplitter>();
		
		int sum_nc =0;
		int sum_maxnc = 0;
		int sum_maxscore = 0;
		int sum_obtained_score = 0;		
		
		int[] params = new int[] {0,0,0,0,};// header, sub-header, additional  notes, questions.
		for(int headerCounter = 1; headerCounter <=listUtilHeader.size(); headerCounter++)
		{
			int number_NC = 0;
			int max_NC = 0;
			
			int max_score = 0;
			int obtained_score = 0;
			double percent_score = 0.00f;
			
			// Creating the response Object
			ERB_Audit_ScorecardSplitter oSplitter = new ERB_Audit_ScorecardSplitter();
			oSplitter.setSectiontype("Header");
			oSplitter.setSectionname(listUtilHeader.get(headerCounter).getValue());
			params[0] = headerCounter;			
			List<ERB_Audit_Mapping> listERB_Audit_Mapping =  oERB_Audit_MappingService.getRecordsByHeaderSubHeaderAddInfoNotQuestions(auditType, 
					params[0], params[1], params[2], params[3]);
			
			for(int quesCounter =1; quesCounter <= listERB_Audit_Mapping.size();quesCounter++ )
			{				
				params[3] = quesCounter;
				// Non Compliances
				ERB_Non_Compliance oERB_Non_Compliance = oNonComplianceRepo.getOneByAuditIdHeaderSubHeaderAddNotesQuestion(audit_id, 
						params[0], params[1], params[2], params[3]);
				if(null != oERB_Non_Compliance)
				{
					number_NC++;
					max_NC = max_NC + oERB_Non_Compliance.getTotal_Score();
				}
				
				// Staging.
				ERB_Audit_Staging oERB_Audit_Staging =  oERB_Audit_StagingRepository.getOneByAuditIdHeaderSubHeaderAddNotesQuestion(audit_id, 
						params[0], params[1], params[2], params[3]);
				if(null == oERB_Audit_Staging)
				{
					continue;
				}
				
				max_score = max_score+oERB_Audit_Staging.getTotal_Score();
				
				if(oERB_Audit_Staging.getObtained_Score() != -2) // -2 means that the N/A is selected for the Question. We should not add the score to the question.
					max_score = max_score+oERB_Audit_Staging.getTotal_Score();
				
				if(oERB_Audit_Staging.getObtained_Score()==oERB_Audit_Staging.getTotal_Score())
				{
					// This means the user have selected Yes. So max points will be given.
					obtained_score = obtained_score + oERB_Audit_Staging.getObtained_Score();
				}
			}
			// Total NCS per section.
			oSplitter.setNctotal(String.valueOf(number_NC));
			sum_nc = sum_nc+number_NC;			
			
			// NC %
			oSplitter.setNcpercent(CommonUtility.calculatePercentage(max_NC, max_score));
			sum_maxnc = sum_maxnc +max_NC;
			
			oSplitter.setMaxscore(String.valueOf(max_score)); 
			sum_maxscore = sum_maxscore +max_score;
			
			oSplitter.setObtainedscore(String.valueOf(obtained_score));
			sum_obtained_score = sum_obtained_score +obtained_score;
			
			oSplitter.setObtainedpercent(CommonUtility.calculatePercentage(obtained_score, max_score));
			percent_score  = obtained_score/max_score *100;
			oSplitter.setGrade(CommonUtility.calculateGrade(percent_score));			
			params[3] = 0; // Re-initiating the question number.
			listSplitter.add(oSplitter);
 		}
		ERB_Audit_ScorecardSplitter oSplitterTotal = new ERB_Audit_ScorecardSplitter();
		oSplitterTotal.setSectiontype("Totals");
		oSplitterTotal.setSectionname("GRAND TOTAL");
		oSplitterTotal.setNctotal(String.valueOf(sum_nc));
		oSplitterTotal.setNcpercent(CommonUtility.calculatePercentage(sum_maxnc, sum_maxscore));
		oSplitterTotal.setMaxscore(String.valueOf(sum_maxscore)); // This will tell you if the calculation is correct. It should be 100.
		oSplitterTotal.setObtainedscore(String.valueOf(sum_obtained_score));
		oSplitterTotal.setObtainedpercent(CommonUtility.calculatePercentage(sum_obtained_score, sum_maxscore));
		double grand_percentage = sum_obtained_score / sum_maxscore * 100;
		oSplitterTotal.setGrade(CommonUtility.calculateGrade(grand_percentage));	
		overallGrade = CommonUtility.calculateGrade(grand_percentage);		
		listSplitter.add(oSplitterTotal);		
		return listSplitter;
	}
	
	public List<ERB_Audit_ScorecardSplitter> getERBConsumerAuditScoreCardSplitterSubHeader(long audit_id, String auditType, List<UtilDTO> listUtilHeader) 
	{
		List<ERB_Audit_ScorecardSplitter> listSplitter = new LinkedList<ERB_Audit_ScorecardSplitter>();
		int[] params = new int[] {0,0,0,0,};// header, sub-header, additional  notes, questions.
		for(int headerCounter = 1; headerCounter <=listUtilHeader.size(); headerCounter++)
		{
			int sum_nc =0;
			int sum_maxnc = 0;
			int sum_maxscore = 0;
			int sum_obtained_score = 0;		
			
			params[0] = headerCounter;
			List<ERB_Audit_Mapping> listERB_Audit_MappingSubHeader =  oERB_Audit_MappingService.getRecordsByHeaderNotSubHeaderNotQuestions(auditType, 
					params[0], params[1], params[2], params[3]);
			for(int subHeaderCounter = 1; subHeaderCounter <=listERB_Audit_MappingSubHeader.size(); subHeaderCounter++)
			{
				int number_NC = 0;
				int max_NC = 0;
				
				int max_score = 0;
				int obtained_score = 0;
				double percent_score = 0.00f;
				
				// Creating the response Object
				ERB_Audit_ScorecardSplitter oSplitter = new ERB_Audit_ScorecardSplitter();
				oSplitter.setSectiontype("Header");
				oSplitter.setSectionname(listUtilHeader.get(headerCounter).getValue());
				params[0] = subHeaderCounter;
				List<ERB_Audit_Mapping> listERB_Audit_MappingQuestion =  oERB_Audit_MappingService.getRecordsByHeaderSubHeaderAddInfoNotQuestions(auditType, 
						params[0], params[1], params[2], params[3]);
				for(int quesCounter =1; quesCounter <= listERB_Audit_MappingQuestion.size();quesCounter++ )
				{				
					params[3] = quesCounter;
					// Non Compliances
					ERB_Non_Compliance oERB_Non_Compliance = oNonComplianceRepo.getOneByAuditIdHeaderSubHeaderAddNotesQuestion(audit_id, 
							params[0], params[1], params[2], params[3]);
					if(null != oERB_Non_Compliance)
					{
						number_NC++;
						max_NC = max_NC + oERB_Non_Compliance.getTotal_Score();
					}
					
					// Staging.
					ERB_Audit_Staging oERB_Audit_Staging =  oERB_Audit_StagingRepository.getOneByAuditIdHeaderSubHeaderAddNotesQuestion(audit_id, 
							params[0], params[1], params[2], params[3]);
					if(null == oERB_Audit_Staging)
					{
						continue;
					}
					
					max_score = max_score+oERB_Audit_Staging.getTotal_Score();
					
					if(oERB_Audit_Staging.getObtained_Score() != -2) // -2 means that the N/A is selected for the Question. We should not add the score to the question.
						max_score = max_score+oERB_Audit_Staging.getTotal_Score();
					
					if(oERB_Audit_Staging.getObtained_Score()==oERB_Audit_Staging.getTotal_Score())
					{
						// This means the user have selected Yes. So max points will be given.
						obtained_score = obtained_score + oERB_Audit_Staging.getObtained_Score();
					}
				}
				// Total NCS per section.
				oSplitter.setNctotal(String.valueOf(number_NC));
				sum_nc = sum_nc+number_NC;			
				
				// NC %
				oSplitter.setNcpercent(CommonUtility.calculatePercentage(max_NC, max_score));
				sum_maxnc = sum_maxnc +max_NC;
				
				oSplitter.setMaxscore(String.valueOf(max_score)); 
				sum_maxscore = sum_maxscore +max_score;
				
				oSplitter.setObtainedscore(String.valueOf(obtained_score));
				sum_obtained_score = sum_obtained_score +obtained_score;
				
				oSplitter.setObtainedpercent(CommonUtility.calculatePercentage(obtained_score, max_score));
				percent_score  = obtained_score/max_score *100;
				oSplitter.setGrade(CommonUtility.calculateGrade(percent_score));			
				params[3] = 0; // Re-initiating the question number.
				listSplitter.add(oSplitter);
			}
			ERB_Audit_ScorecardSplitter oSplitterTotal = new ERB_Audit_ScorecardSplitter();
			oSplitterTotal.setSectiontype("Totals");
			oSplitterTotal.setSectionname("GRAND TOTAL");
			oSplitterTotal.setNctotal(String.valueOf(sum_nc));
			oSplitterTotal.setNcpercent(CommonUtility.calculatePercentage(sum_maxnc, sum_maxscore));
			oSplitterTotal.setMaxscore(String.valueOf(sum_maxscore)); // This will tell you if the calculation is correct. It should be 100.
			oSplitterTotal.setObtainedscore(String.valueOf(sum_obtained_score));
			oSplitterTotal.setObtainedpercent(CommonUtility.calculatePercentage(sum_obtained_score, sum_maxscore));
			double grand_percentage = sum_obtained_score / sum_maxscore * 100;
			oSplitterTotal.setGrade(CommonUtility.calculateGrade(grand_percentage));	
			
			listSplitter.add(oSplitterTotal);
 		}
				
		return listSplitter;
	}
	@Override
	public List<ScoreCardDTO> getAllScoreCardByAuditIds(List<Long> auditIds) {
		List<ScoreCard> scoreCardList = oScoreCardRepository.findByAudit_Id(auditIds);
        return scoreCardList.stream().map(ScoreCardMapper::maptoDTO).toList();
	}

	@Override
	public List<AuditScoreProjection> getAllScoreCardByStations(long loginUserId, Date startDate) {
		List<AuditScoreProjection> auditScoreProjectionList = new ArrayList<>();

		List<StationsDTO> listStationsDTO = oClustersService.getAllStationsForClusterManagerid(loginUserId);
		if (listStationsDTO.isEmpty())
			return auditScoreProjectionList;

		List<String> stationCodeList = listStationsDTO.stream().map(StationsDTO::getStationcode).toList();

		auditScoreProjectionList = oScoreCardRepository.findScoresByStations("Completed", loginUserId, stationCodeList, startDate);

		return auditScoreProjectionList;
	}

	@Override
	public Optional<AuditScoreSummary> getAuditScoreSummary(List<Long> auditIds) {
//		Optional<AuditScoreSummaryProjection> projection = oScoreCardRepository.findScoresByAuditIds(auditIds);

//		if (projection.isPresent()) {
//			AuditScoreSummaryProjection p = projection.get();
//			Double avgScore = CommonUtility.calculateAvgScore(p.getObtainedScoreSum(), p.getTotalScoreSum());
//			String grade = CommonUtility.calculateGrade(avgScore);
//			return Optional.of(new AuditScoreSummary(
////                    p.getObtainedScoreSum(),
////                    p.getTotalScoreSum(),
//                    avgScore,
//                    grade
//            ));
//		} else {
//			return Optional.empty();
//		}

		return null;
	}
}
