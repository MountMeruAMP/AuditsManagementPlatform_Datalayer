package com.mountmeru.entitymanagement.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import com.mountmeru.entitymanagement.dto.*;
import com.mountmeru.entitymanagement.service.*;
import com.mountmeru.entitymanagement.utils.Constants;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mountmeru.entitymanagement.entity.Audit_Master;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Final;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Staging;
import com.mountmeru.entitymanagement.entity.Roles;
import com.mountmeru.entitymanagement.jsonresponses.CompletedAuditResponse;
import com.mountmeru.entitymanagement.jsonresponses.CompletedAuditsTable;
import com.mountmeru.entitymanagement.jsonresponses.UpcomingAuditsResponse;
import com.mountmeru.entitymanagement.jsonresponses.UpcomingAuditsTable;
import com.mountmeru.entitymanagement.mapper.Audit_MasterMapper;
import com.mountmeru.entitymanagement.mapper.ERB_Audit_StagingToFinalMapper;
import com.mountmeru.entitymanagement.repository.Audit_MasterRepository;
import com.mountmeru.entitymanagement.repository.ERB_Audit_StagingRepository;
import com.mountmeru.entitymanagement.repository.RolesRepository;
import com.mountmeru.entitymanagement.utils.DateUtils;
@Service
public class Audit_MasterServiceImpl implements Audit_MasterService {
	
	org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImplementation.class);
	
	@Autowired
	DateUtils oDateUtils;	
	
	@Autowired
	UtilService oUtilService;	
	
	@Autowired
	UsersService oUsersService;
	
	@Autowired
	RolesService oRolesService;
	
	@Autowired
	ClustersService  oClustersService; 
	
	@Value("${application.upcomingaudits.days}")
	String upcomingauditsdays;
	
	@Value("${application.completedaudits.days}")
	String completedauditsdays;
	
	
	@Autowired
	ERB_Audit_StagingRepository oERB_Audit_StagingRepo;
	
	@Autowired
	ERB_Audit_StagingService  oERB_Audit_StagingService;
	
	@Autowired
	StationsService oStationsService;
	private Audit_MasterRepository oAudit_MasterRepository;
	
	@Autowired 
	RolesRepository roleRepo;

	@Autowired
	private EmailService oEmailService;

	
	public Audit_MasterServiceImpl(Audit_MasterRepository oAudit_MasterRepository)
	{
		this.oAudit_MasterRepository = oAudit_MasterRepository; 
	}
	
	@Override
	public UpcomingAuditsResponse getAllUpComingAudits(long loginUserId) {
		// TODO Auto-generated method stub
		// 1. Get User id and hit Users table for role
		UsersDTO oUsers = oUsersService.getUsersByUserId(loginUserId);
		if(null == oUsers)
		{
			throw new RuntimeErrorException(new Error(), "Invalid User.");

		}
		// 2. Get the role id and get the Role
		Roles oRoles = roleRepo.findRoleByRoleId(oUsers.getRole());
		if(null == oRoles)
		{
			throw new RuntimeErrorException(new Error(), "Invalid Role Assigned to the User.");
		}
		String role = oRoles.getRoleName();
		return getAllRoleBasedUpcomingAudits( oRoles.getRoleName(), loginUserId);
		
	}
	@SuppressWarnings({ "deprecation", "deprecation" })
	public UpcomingAuditsResponse getAllRoleBasedUpcomingAudits(String role, long loginUserId)
	{
		UpcomingAuditsResponse oUpcomingAuditsDTO = new UpcomingAuditsResponse();	
		List<UpcomingAuditsTable> listTableDTO = new ArrayList<UpcomingAuditsTable>();
		if("Station Manager".equalsIgnoreCase(role))
		{
			// 3a. If Role = Station Manager --> Get all the audits for the station.
			oUpcomingAuditsDTO.setPendingaudits("Pending Audits due in next " + upcomingauditsdays+ " under this Station");
			// Loop all the stations under the station manager.
			List<StationsDTO> listStationsDTO = oStationsService.getAllStationsUnderStationManager(loginUserId);
			if(listStationsDTO.isEmpty())
				return oUpcomingAuditsDTO;
			for( StationsDTO station :listStationsDTO )
			{
				List<Audit_Master> listAudits = oAudit_MasterRepository.findAllAuditsForStation("Scheduled",station.getStationcode());
				List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForStation("Completed",station.getStationcode()); 
				if(listAudits.isEmpty())
				{
					oUpcomingAuditsDTO.setNumberofaudits("0");
					return oUpcomingAuditsDTO;
				}
				for(Audit_Master oAudit_master :listAudits)
				{	UpcomingAuditsTable tableDTO = new UpcomingAuditsTable();
					tableDTO.setAuditid(String.valueOf(oAudit_master.getId()));
					tableDTO.setAudittype(oAudit_master.getType());
					StationsDTO oStationDTO = oStationsService.getStationsById(oAudit_master.getStationCode());
					if(!StringUtils.isEmpty(oStationDTO))
						tableDTO.setStationname(oStationDTO.getStationname());
					List<UtilDTO>  listUtilDTO =  oUtilService.getAllRowsByValue(oAudit_master.getType());
					if(!listUtilDTO.isEmpty())
						tableDTO.setAuditname(listUtilDTO.get(0).getPlaceholder_1());
					tableDTO.setDuedate(oDateUtils.convertTimeStampToDate(oAudit_master.getCreatedTS(), "dd-MM-yyyy"));
					if(!listCompletedAudits.isEmpty())
					{
						tableDTO.setLastauditdate(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getCreatedTS(), "dd-MM-yyyy"));
					}
					else
					{
						tableDTO.setLastauditdate("Not Applicable");
					}
					listTableDTO.add(tableDTO);
				}
				oUpcomingAuditsDTO.setNumberofaudits(String.valueOf(listTableDTO.size()));
				oUpcomingAuditsDTO.setListUpcomingAuditsTableDTO(listTableDTO);
			}
		}
		else if("Auditor".equalsIgnoreCase(role))
		{
			oUpcomingAuditsDTO.setPendingaudits("Pending Audits due in next " + upcomingauditsdays+ " for the Auditor");
			// 3b. If Role = Auditor --> Get all Upcoming Audits for the Auditor as user id.
			List<Audit_Master> listAudits = oAudit_MasterRepository.findAllAuditsForAuditor("Scheduled",loginUserId);
			List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForAuditor("Completed",loginUserId); 
			
			if(listAudits.isEmpty())
			{
				oUpcomingAuditsDTO.setNumberofaudits("0");
				return oUpcomingAuditsDTO;
			}
			for(Audit_Master oAudit_master :listAudits)
			{	UpcomingAuditsTable tableDTO = new UpcomingAuditsTable();
				tableDTO.setAuditid(String.valueOf(oAudit_master.getId()));
				tableDTO.setAudittype(oAudit_master.getType());
				StationsDTO oStationDTO = oStationsService.getStationsById(oAudit_master.getStationCode());
				if(!StringUtils.isEmpty(oStationDTO))
					tableDTO.setStationname(oStationDTO.getStationname());
				List<UtilDTO>  listUtilDTO =  oUtilService.getAllRowsByValue(oAudit_master.getType());
				if(!listUtilDTO.isEmpty())
					tableDTO.setAuditname(listUtilDTO.get(0).getPlaceholder_1());
				tableDTO.setDuedate(oDateUtils.convertTimeStampToDate(oAudit_master.getCreatedTS(), "dd-MM-yyyy"));
				if(!listCompletedAudits.isEmpty())
				{
					tableDTO.setLastauditdate(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getCreatedTS(), "dd-MM-yyyy"));
				}
				else
				{
					tableDTO.setLastauditdate("Not Applicable");
				}
				listTableDTO.add(tableDTO);
			}
			oUpcomingAuditsDTO.setNumberofaudits(String.valueOf(listTableDTO.size()));
			oUpcomingAuditsDTO.setListUpcomingAuditsTableDTO(listTableDTO);
		}
		else if("Cluster Manager".equalsIgnoreCase(role))
		{
			oUpcomingAuditsDTO.setPendingaudits("Pending Audits due in next " + upcomingauditsdays+ " under this Cluster");
			// 3c. If Role = ClusterManager --> Get all the Stations in the Cluster, Get all the audits for each station.
			// Loop all the stations under a cluster manager.
			List<StationsDTO> listStationsDTO = oClustersService.getAllStationsForClusterManagerid(loginUserId);
			if(listStationsDTO.isEmpty())
				return oUpcomingAuditsDTO;
			for( StationsDTO station :listStationsDTO )
			{
				List<Audit_Master> listAudits = oAudit_MasterRepository.findAllAuditsForStation("Scheduled",station.getStationcode());
				List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForStation("Completed",station.getStationcode()); 
				if(listAudits.isEmpty())
				{
					oUpcomingAuditsDTO.setNumberofaudits("0");
					return oUpcomingAuditsDTO;
				}
				for(Audit_Master oAudit_master :listAudits)
				{	UpcomingAuditsTable tableDTO = new UpcomingAuditsTable();
				tableDTO.setAuditid(String.valueOf(oAudit_master.getId()));
				tableDTO.setAudittype(oAudit_master.getType());
				StationsDTO oStationDTO = oStationsService.getStationsById(oAudit_master.getStationCode());
				if(!StringUtils.isEmpty(oStationDTO))
					tableDTO.setStationname(oStationDTO.getStationname());
				List<UtilDTO>  listUtilDTO =  oUtilService.getAllRowsByValue(oAudit_master.getType());
				if(!listUtilDTO.isEmpty())
					tableDTO.setAuditname(listUtilDTO.get(0).getPlaceholder_1());
				tableDTO.setDuedate(oDateUtils.convertTimeStampToDate(oAudit_master.getCreatedTS(), "dd-MM-yyyy"));
				if(!listCompletedAudits.isEmpty())
				{
					tableDTO.setLastauditdate(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getCreatedTS(), "dd-MM-yyyy"));
				}
				else
				{
					tableDTO.setLastauditdate("Not Applicable");
				}
				listTableDTO.add(tableDTO);
				}
				oUpcomingAuditsDTO.setNumberofaudits(String.valueOf(listTableDTO.size()));
				oUpcomingAuditsDTO.setListUpcomingAuditsTableDTO(listTableDTO);
			}
		}
		return oUpcomingAuditsDTO;
	}
	
	@Override
	public Audit_MasterDTO createAuditMaster(Audit_MasterDTO auditMasterDTO, long loginUserId) {
		// TODO Auto-generated method stub
		Audit_Master audit_master = Audit_MasterMapper.mapToObject(auditMasterDTO); 
		audit_master.setCreatedBy(loginUserId);
		audit_master.setCreatedTS(oDateUtils.getCurrentTimeStamp());
		
		log.debug("Saving the record.");	 
		try {
			Audit_Master savedAudit = oAudit_MasterRepository.save(audit_master);
			return Audit_MasterMapper.maptoDTO(savedAudit);	
		}
		catch(Exception e)
		{
			log.error("Error while saving the record {}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeErrorException(new Error(), "Exception occurred while creating Audit master record.");
		}
	}
	@Override
	public Audit_MasterDTO startAudit(Audit_MasterDTO auditMasterDTO, long loginUserId) {

		// TODO Auto-generated method stub
		Audit_Master audit_master = Audit_MasterMapper.mapToObject(auditMasterDTO); 
		audit_master.setUpdatedBy(loginUserId);
		audit_master.setUpdatedTS(oDateUtils.getCurrentTimeStamp());
		audit_master.setStartTime(oDateUtils.getCurrentTimeStamp()); 
		audit_master.setState("In-Progress");
		
		try {
			Audit_Master savedAudit = oAudit_MasterRepository.save(audit_master);
			return Audit_MasterMapper.maptoDTO(savedAudit);	
		}
		catch(Exception e)
		{
			log.error("Error while saving the record {}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeErrorException(new Error(), "Exception occurred while starting the  Audit.");
		}	
	}

	@Override
	public Audit_MasterDTO updateAuditMaster(Audit_MasterDTO auditMasterDTO, long loginUserId) {
		// TODO Auto-generated method stub
		Audit_Master audit_master = Audit_MasterMapper.mapToObject(auditMasterDTO); 
		audit_master.setUpdatedBy(loginUserId);
		audit_master.setUpdatedTS(oDateUtils.getCurrentTimeStamp());
		
		try {
			Audit_Master savedAudit = oAudit_MasterRepository.save(audit_master);
			return Audit_MasterMapper.maptoDTO(savedAudit);	
		}
		catch(Exception e)
		{
			log.error("Error while saving the record {}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeErrorException(new Error(), "Exception occurred while updating Audit master record.");
		}
	}
	
	public Audit_MasterDTO updateAuditState(Audit_MasterDTO auditMasterDTO, long loginUserId, String state) 
	{
		Audit_Master audit_master = Audit_MasterMapper.mapToObject(auditMasterDTO); 
		audit_master.setUpdatedBy(loginUserId);
		audit_master.setUpdatedTS(oDateUtils.getCurrentTimeStamp());
		
		audit_master.setState(state);
		
		try {
			Audit_Master savedAudit = oAudit_MasterRepository.save(audit_master);
			return Audit_MasterMapper.maptoDTO(savedAudit);	
		}
		catch(Exception e)
		{
			log.error("Error while saving the record {}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeErrorException(new Error(), "Exception occurred while updating Audit master record.");
		}
	}
	@Override
	public Audit_MasterDTO submitAudit(Audit_MasterDTO auditMasterDTO, long loginUserId) 
	{
		// TODO
		//2. Create PDF of the Audit save it in the file system. 
		
		//TODO
		//3. Create the Email Service. Send the email to the Station's email Id and Station Manager, Auditor for Physical Signature attaching the file.
		
		//4. Submit the Audit. Change the state of the Audit to Submitted.

		Audit_Master audit_master = Audit_MasterMapper.mapToObject(auditMasterDTO); 
		audit_master.setUpdatedBy(loginUserId);
		audit_master.setUpdatedTS(oDateUtils.getCurrentTimeStamp());
		
		audit_master.setState("Submitted");
		
		audit_master.setDoc_Submitted_FileName("Submitted File Name");
		audit_master.setDoc_Submitted_FilePath("Submitted File Path");
		
		
		try {
			Audit_Master savedAudit = oAudit_MasterRepository.save(audit_master);
			return Audit_MasterMapper.maptoDTO(savedAudit);	
			
		}
		catch(Exception e)
		{
			log.error("Error while saving the record {}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeErrorException(new Error(), "Exception occurred while updating Audit master record.");
		}
	}
	@Override
	public Audit_MasterDTO uploadFinalAuditDocuments(Audit_MasterDTO auditMasterDTO, long loginUserId) 
	{
		// TODO
		//1. Save the PDF document in the file System
		
		//TODO
		//2. Create the Email Service. Send the email to the Cluster Manager, Region Manager,Station Manager, 
		//Auditor attaching the physically signed file.

		// from auditMasterDTO get the station code -> from station table, fetch station manager, cluster
		// -> from user fetch email, from cluster get id -> from user fetch email by cluster
		StationsDTO station = oStationsService.getStationsById(auditMasterDTO.getStationcode());
		if (null == station) {
			throw new RuntimeErrorException(new Error(), "No station found");
		}

		ClustersDTO cluster = oClustersService.getClusterById(station.getClusterid());
		if (null == cluster) {
			throw new RuntimeErrorException(new Error(), "No cluster found");
		}

		UsersDTO userCM = oUsersService.getUsersByUserId(NumberUtils.toLong(cluster.getManagerid()));
		UsersDTO userSM = oUsersService.getUsersByUserId(NumberUtils.toLong(station.getManager_id()));

		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setToMultiple(new String[]{userCM.getEmail(), userSM.getEmail(), "arindam.deb@infinivalue.com"});
		emailDTO.setSubject(Constants.EMAIL_SUBJECT);
		emailDTO.setContent(Constants.EMAIL_CONTENT);

		// send email
		oEmailService.sendEmail(emailDTO);
//		oEmailService.sendEmail(emailDTO, template, pdf);

		//3. Submit the Audit. Change the state of the Audit to Completed.
		Audit_Master audit_master = Audit_MasterMapper.mapToObject(auditMasterDTO); 
		audit_master.setUpdatedBy(loginUserId);
		audit_master.setUpdatedTS(oDateUtils.getCurrentTimeStamp());
		audit_master.setEndTime(oDateUtils.getCurrentTimeStamp());
		audit_master.setState("Completed");

//		TODO: pass generated pdf
		audit_master.setDoc_Uploaded_FileName("Uploaded File Name");
		audit_master.setDoc_Uploaded_FilePath("Uploaded File Path"); 
		
		//4. Copy the Audit data from Staging Table to Final Table.
		List<ERB_Audit_Staging> objList = oERB_Audit_StagingRepo.findAllRecordsByAuditId(audit_master.getId());
		for(ERB_Audit_Staging obj : objList)
		{
			ERB_Audit_Final oFinal = ERB_Audit_StagingToFinalMapper.convertStagingToFinal(obj);
			oFinal.setCreatedBy(loginUserId);
			oFinal.setUpdatedBy(0);
			oFinal.setCreatedTS(oDateUtils.getCurrentTimeStamp());
			oFinal.setUpdatedTS(null);
		}
		// 6. Create score card Table.
		//ERB_Audit_ScoreCardDTO oERB_Audit_ScoreCardDTO = oERB_Audit_StagingService.getERBScoreCard(audit_master.getId(), loginUserId);
		
		//7. Create Non-Complaince.
		
		
		// Final save into the Database. Single commit.
		try {
			Audit_Master savedAudit = oAudit_MasterRepository.save(audit_master);
			return Audit_MasterMapper.maptoDTO(savedAudit);

		}
		catch(Exception e)
		{
			log.error("Error while saving the record {}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeErrorException(new Error(), "Exception occurred while updating Audit master record.");
		}
//		return Audit_MasterMapper.maptoDTO(audit_master);
	}
	
	
	// TODO to be moved to different Service.
    @Override
    public CompletedAuditResponse getAllCompletedAudits(long loginUserId, String fromDate, String toDate) {
        // 1. Get User id and hit Users table for role
        UsersDTO oUsers = oUsersService.getUsersByUserId(loginUserId);
        if (null == oUsers) {
            throw new RuntimeErrorException(new Error(), "Invalid User.");

        }
        // 2. Get the role id and get the Role
        Roles oRoles = roleRepo.findRoleByRoleId(oUsers.getRole());
        if (null == oRoles) {
            throw new RuntimeErrorException(new Error(), "Invalid Role Assigned to the User.");
        }
//        String role = oRoles.getRoleName();
//        return getAllRoleBasedCompletedAudits(oRoles.getRoleName(), loginUserId, fromDate, toDate);
        return getAllRoleBasedCompletedAudits(oRoles.getRoleName(), loginUserId);
    }

    public CompletedAuditResponse getAllRoleBasedCompletedAudits(String role, long loginUserId) {
//        List<Audit_MasterDTO> listAuditMasterDTO = new ArrayList<Audit_MasterDTO>();

        CompletedAuditResponse oCompletedAuditResponse = new CompletedAuditResponse();
        oCompletedAuditResponse.setUserId(loginUserId);
        Integer ERBCON = 0, ERBTECH = 0, HSE = 0, FUEL = 0;
        String days = completedauditsdays;

        Date to = new Date();
        Date from = oDateUtils.subtractDaysToToday(Integer.parseInt(completedauditsdays) + 1);
        long differenceInMilliSeconds = to.getTime() - from.getTime();
        long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMilliSeconds);
        days = String.valueOf(Math.abs(differenceInDays));

        List<CompletedAuditsTable> listTableDTO = new ArrayList<>();
        if ("Station Manager".equalsIgnoreCase(role)) {
            // 3a. If Role = Station Manager --> Get all the audits for the station.
            oCompletedAuditResponse.setCompletedaudits("Completed Audits in last " + completedauditsdays + " under this Station");
            // Loop all the stations under the station manager.
            List<StationsDTO> listStationsDTO = oStationsService.getAllStationsUnderStationManager(loginUserId);
            if (listStationsDTO.isEmpty())
                return oCompletedAuditResponse;

            List<String> stationCodeList = listStationsDTO.stream().map(StationsDTO::getStationcode).toList();

            List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForStationByDate("Completed", stationCodeList, loginUserId, from, to);
            if (listCompletedAudits.isEmpty()) {
                oCompletedAuditResponse.setNumberofaudits("0");
                return oCompletedAuditResponse;
            }

            for (Audit_Master oAudit_master : listCompletedAudits) {
                CompletedAuditsTable tableDTO = new CompletedAuditsTable();
                tableDTO.setAuditid(String.valueOf(oAudit_master.getId()));
                tableDTO.setAudittype(oAudit_master.getType());

                StationsDTO oStationDTO = oStationsService.getStationsById(oAudit_master.getStationCode());
                if (!StringUtils.isEmpty(oStationDTO))
                    tableDTO.setStationname(oStationDTO.getStationname());

                List<UtilDTO> listUtilDTO = oUtilService.getAllRowsByValue(oAudit_master.getType());

                if (!listUtilDTO.isEmpty())
                    tableDTO.setAuditname(listUtilDTO.get(0).getPlaceholder_1());

                tableDTO.setDuedate(oDateUtils.convertTimeStampToDate(oAudit_master.getEndTime(), "dd-MM-yyyy"));

                if (!listCompletedAudits.isEmpty()) {
                    tableDTO.setLastauditdate(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getCreatedTS(), "dd-MM-yyyy"));
                } else {
                    tableDTO.setLastauditdate("Not Applicable");
                }

                switch (oAudit_master.getType()) {
                    case "ERBCONA":
                        ERBCON++;
                        break;
                    case "ERBTECH":
                        ERBTECH++;
                        break;
                    case "HSE":
                        HSE++;
                        break;
                    case "FUEL":
                        FUEL++;
                        break;
                }
                listTableDTO.add(tableDTO);
            }
            oCompletedAuditResponse.setNumberofaudits(String.valueOf(listTableDTO.size()));
            oCompletedAuditResponse.setNumberofERBCONAaudits(ERBCON.toString());
            oCompletedAuditResponse.setNumberofERBTECHaudits(ERBTECH.toString());
            oCompletedAuditResponse.setNumberofHSEaudits(HSE.toString());
            oCompletedAuditResponse.setNumberofFUELaudits(FUEL.toString());
//            oCompletedAuditResponse.setFromdate(oDateUtils.parseDateToString(from));
//            oCompletedAuditResponse.setTodate(oDateUtils.parseDateToString(to));
            oCompletedAuditResponse.setCompletedAuditList(listTableDTO);
        }
        else if ("Auditor".equalsIgnoreCase(role)) {
            oCompletedAuditResponse.setCompletedaudits("Completed Audits in last " + completedauditsdays + " for the Auditor");
            // 3b. If Role = Auditor --> Get all Upcoming Audits for the Auditor as user id.
//            List<Audit_Master> listAudits = oAudit_MasterRepository.findAllAuditsForAuditor("Scheduled", loginUserId);
            List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForAuditor("Completed", loginUserId);

            if (listCompletedAudits.isEmpty()) {
                oCompletedAuditResponse.setNumberofaudits("0");
                return oCompletedAuditResponse;
            }
//            List<String> stationCodeList = listStationsDTO.stream().map(StationsDTO::getStationcode).toList();

            for (Audit_Master oAudit_master : listCompletedAudits) {
                CompletedAuditsTable tableDTO = new CompletedAuditsTable();
                tableDTO.setAuditid(String.valueOf(oAudit_master.getId()));
                tableDTO.setAudittype(oAudit_master.getType());

                StationsDTO oStationDTO = oStationsService.getStationsById(oAudit_master.getStationCode());

                if (!StringUtils.isEmpty(oStationDTO)) {
                    tableDTO.setStationname(oStationDTO.getStationname());
                    tableDTO.setStationcode(oStationDTO.getStationcode());
                }

                List<UtilDTO> listUtilDTO = oUtilService.getAllRowsByValue(oAudit_master.getType());

                if (!listUtilDTO.isEmpty())
                    tableDTO.setAuditname(listUtilDTO.get(0).getPlaceholder_1());

                tableDTO.setDuedate(oDateUtils.convertTimeStampToDate(oAudit_master.getEndTime(), "dd-MM-yyyy"));

                if (!listCompletedAudits.isEmpty()) {
                    tableDTO.setLastauditdate(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getCreatedTS(), "dd-MM-yyyy"));
                } else {
                    tableDTO.setLastauditdate("Not Applicable");
                }

                tableDTO.setStarttime(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getStartTime(), "dd-MM-yyyy"));

                switch (oAudit_master.getType()) {
                    case "ERBCONA":
                        ERBCON++;
                        break;
                    case "ERBTECH":
                        ERBTECH++;
                        break;
                    case "HSE":
                        HSE++;
                        break;
                    case "FUEL":
                        FUEL++;
                        break;
                }
                listTableDTO.add(tableDTO);
            }
            oCompletedAuditResponse.setNumberofaudits(String.valueOf(listTableDTO.size()));
            oCompletedAuditResponse.setNumberofERBCONAaudits(ERBCON.toString());
            oCompletedAuditResponse.setNumberofERBTECHaudits(ERBTECH.toString());
            oCompletedAuditResponse.setNumberofHSEaudits(HSE.toString());
            oCompletedAuditResponse.setNumberofFUELaudits(FUEL.toString());
//            oCompletedAuditResponse.setFromdate(oDateUtils.parseDateToString(from));
//            oCompletedAuditResponse.setTodate(oDateUtils.parseDateToString(to));
            oCompletedAuditResponse.setCompletedAuditList(listTableDTO);

        }
        else if ("Cluster Manager".equalsIgnoreCase(role)) {

            oCompletedAuditResponse.setCompletedaudits("Completed Audits in last " + days + " under this Cluster");
            // 3c. If Role = ClusterManager --> Get all the Stations in the Cluster, Get all the audits for each station.

            List<StationsDTO> listStationsDTO = oClustersService.getAllStationsForClusterManagerid(loginUserId);
            if (listStationsDTO.isEmpty())
                return oCompletedAuditResponse;

            List<String> stationCodeList = listStationsDTO.stream().map(StationsDTO::getStationcode).toList();

            List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForStationByDate("Completed", stationCodeList, loginUserId, from, to);
//            List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForStationByDateTest(to, from);
            if (listCompletedAudits.isEmpty()) {
                oCompletedAuditResponse.setNumberofaudits("0");
                return oCompletedAuditResponse;
            }

            for (Audit_Master oAudit_master : listCompletedAudits) {
                CompletedAuditsTable tableDTO = new CompletedAuditsTable();
                tableDTO.setAuditid(String.valueOf(oAudit_master.getId()));
                tableDTO.setAudittype(oAudit_master.getType());

                StationsDTO oStationDTO = oStationsService.getStationsById(oAudit_master.getStationCode());

                if (!StringUtils.isEmpty(oStationDTO)) {
                    tableDTO.setStationname(oStationDTO.getStationname());
                    tableDTO.setStationcode(oStationDTO.getStationcode());
                }

                List<UtilDTO> listUtilDTO = oUtilService.getAllRowsByValue(oAudit_master.getType());

                if (!listUtilDTO.isEmpty())
                    tableDTO.setAuditname(listUtilDTO.get(0).getPlaceholder_1());

                tableDTO.setDuedate(oDateUtils.convertTimeStampToDate(oAudit_master.getEndTime(), "dd-MM-yyyy"));

                if (!listCompletedAudits.isEmpty()) {
                    tableDTO.setLastauditdate(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getCreatedTS(), "dd-MM-yyyy"));
                } else {
                    tableDTO.setLastauditdate("Not Applicable");
                }

                tableDTO.setStarttime(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getStartTime(), "dd-MM-yyyy"));

                switch (oAudit_master.getType()) {
                    case "ERBCONA":
                        ERBCON++;
                        break;
                    case "ERBTECH":
                        ERBTECH++;
                        break;
                    case "HSE":
                        HSE++;
                        break;
                    case "FUEL":
                        FUEL++;
                        break;
                }
                listTableDTO.add(tableDTO);
            }
            oCompletedAuditResponse.setNumberofaudits(String.valueOf(listTableDTO.size()));
            oCompletedAuditResponse.setNumberofERBCONAaudits(ERBCON.toString());
            oCompletedAuditResponse.setNumberofERBTECHaudits(ERBTECH.toString());
            oCompletedAuditResponse.setNumberofHSEaudits(HSE.toString());
            oCompletedAuditResponse.setNumberofFUELaudits(FUEL.toString());
            oCompletedAuditResponse.setCompletedAuditList(listTableDTO);

        }
        return oCompletedAuditResponse;
    }

    // working on it
//    public CompletedAuditResponse getAllRoleBasedCompletedAudits(String role, long loginUserId, String fromDate, String toDate) {
////        List<Audit_MasterDTO> listAuditMasterDTO = new ArrayList<Audit_MasterDTO>();
//
//        CompletedAuditResponse oCompletedAuditResponse = new CompletedAuditResponse();
//        Integer ERBCON = 0, ERBTECH = 0, HSE = 0, FUEL = 0;
//        String days = completedauditsdays;
//
//        Date to = StringUtils.hasLength(fromDate) ? DateUtils.convertStringToDate(fromDate, Constants.dateFormat_mm_dd_yyyy) : new Date();
//        Date from = StringUtils.hasLength(toDate) ? DateUtils.convertStringToDate(toDate, Constants.dateFormat_mm_dd_yyyy) : oDateUtils.subtractDaysToToday(Integer.parseInt(completedauditsdays) + 1);
//        long differenceInMilliSeconds = to.getTime() - from.getTime();
//        long differenceInDays = TimeUnit.MILLISECONDS.toDays(differenceInMilliSeconds);
//        days = String.valueOf(Math.abs(differenceInDays));
//
//        List<CompletedAuditsTable> listTableDTO = new ArrayList<>();
//        if ("Station Manager".equalsIgnoreCase(role)) {
//            // 3a. If Role = Station Manager --> Get all the audits for the station.
//            oCompletedAuditResponse.setCompletedaudits("Completed Audits in last " + completedauditsdays + " under this Station");
//            // Loop all the stations under the station manager.
//            List<StationsDTO> listStationsDTO = oStationsService.getAllStationsUnderStationManager(loginUserId);
//            if (listStationsDTO.isEmpty())
//                return oCompletedAuditResponse;
//
//            List<String> stationCodeList = listStationsDTO.stream().map(StationsDTO::getStationcode).toList();
//
//            List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForStationByDate("Completed", stationCodeList,loginUserId, to, from);
//            if (listCompletedAudits.isEmpty()) {
//                oCompletedAuditResponse.setNumberofaudits("0");
//                return oCompletedAuditResponse;
//            }
//
//            for (Audit_Master oAudit_master : listCompletedAudits) {
//                CompletedAuditsTable tableDTO = new CompletedAuditsTable();
//                tableDTO.setAuditid(String.valueOf(oAudit_master.getId()));
//                tableDTO.setAudittype(oAudit_master.getType());
//
//                StationsDTO oStationDTO = oStationsService.getStationsById(oAudit_master.getStationCode());
//                if (!StringUtils.isEmpty(oStationDTO))
//                    tableDTO.setStationname(oStationDTO.getStationname());
//
//                List<UtilDTO> listUtilDTO = oUtilService.getAllRowsByValue(oAudit_master.getType());
//
//                if (!listUtilDTO.isEmpty())
//                    tableDTO.setAuditname(listUtilDTO.get(0).getPlaceholder_1());
//
//                tableDTO.setDuedate(oDateUtils.convertTimeStampToDate(oAudit_master.getCreatedTS(), "dd-MM-yyyy"));
//
//                if (!listCompletedAudits.isEmpty()) {
//                    tableDTO.setLastauditdate(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getCreatedTS(), "dd-MM-yyyy"));
//                } else {
//                    tableDTO.setLastauditdate("Not Applicable");
//                }
//
//                switch (oAudit_master.getType()) {
//                    case "ERBCONA":
//                        ERBCON++;
//                        break;
//                    case "ERBTECH":
//                        ERBTECH++;
//                        break;
//                    case "HSE":
//                        HSE++;
//                        break;
//                    case "FUEL":
//                        FUEL++;
//                        break;
//                }
//                listTableDTO.add(tableDTO);
//            }
//            oCompletedAuditResponse.setNumberofaudits(String.valueOf(listTableDTO.size()));
//            oCompletedAuditResponse.setNumberofERBCONAaudits(ERBCON.toString());
//            oCompletedAuditResponse.setNumberofERBTECHaudits(ERBTECH.toString());
//            oCompletedAuditResponse.setNumberofHSEaudits(HSE.toString());
//            oCompletedAuditResponse.setNumberofFUELaudits(FUEL.toString());
////            oCompletedAuditResponse.setFromdate(oDateUtils.parseDateToString(from));
////            oCompletedAuditResponse.setTodate(oDateUtils.parseDateToString(to));
//            oCompletedAuditResponse.setCompletedAuditList(listTableDTO);
//
//        } else if ("Auditor".equalsIgnoreCase(role)) {
//            oCompletedAuditResponse.setCompletedaudits("Completed Audits in last " + completedauditsdays + " for the Auditor");
//            // 3b. If Role = Auditor --> Get all Upcoming Audits for the Auditor as user id.
////            List<Audit_Master> listAudits = oAudit_MasterRepository.findAllAuditsForAuditor("Scheduled", loginUserId);
//            List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForAuditor("Completed", loginUserId);
//
//            if (listCompletedAudits.isEmpty()) {
//                oCompletedAuditResponse.setNumberofaudits("0");
//                return oCompletedAuditResponse;
//            }
//            for (Audit_Master oAudit_master : listCompletedAudits) {
//                CompletedAuditsTable tableDTO = new CompletedAuditsTable();
//                tableDTO.setAuditid(String.valueOf(oAudit_master.getId()));
//                tableDTO.setAudittype(oAudit_master.getType());
//                StationsDTO oStationDTO = oStationsService.getStationsById(oAudit_master.getStationCode());
//                if (!StringUtils.isEmpty(oStationDTO))
//                    tableDTO.setStationname(oStationDTO.getStationname());
//                List<UtilDTO> listUtilDTO = oUtilService.getAllRowsByValue(oAudit_master.getType());
//                if (!listUtilDTO.isEmpty())
//                    tableDTO.setAuditname(listUtilDTO.get(0).getPlaceholder_1());
//                tableDTO.setDuedate(oDateUtils.convertTimeStampToDate(oAudit_master.getCreatedTS(), "dd-MM-yyyy"));
//                if (!listCompletedAudits.isEmpty()) {
//                    tableDTO.setLastauditdate(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getCreatedTS(), "dd-MM-yyyy"));
//                } else {
//                    tableDTO.setLastauditdate("Not Applicable");
//                }
//                listTableDTO.add(tableDTO);
//            }
//            oCompletedAuditResponse.setNumberofaudits(String.valueOf(listTableDTO.size()));
//            oCompletedAuditResponse.setCompletedAuditList(listTableDTO);
//
//        } else if ("Cluster Manager".equalsIgnoreCase(role)) {
//
//            oCompletedAuditResponse.setCompletedaudits("Completed Audits in last " + days + " under this Cluster");
//            // 3c. If Role = ClusterManager --> Get all the Stations in the Cluster, Get all the audits for each station.
//
//            List<StationsDTO> listStationsDTO = oClustersService.getAllStationsForClusterManagerid(loginUserId);
//            if (listStationsDTO.isEmpty())
//                return oCompletedAuditResponse;
//
//            List<String> stationCodeList = listStationsDTO.stream().map(StationsDTO::getStationcode).toList();
//
//            List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForStationByDate("Completed", stationCodeList, to, from);
////            List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForStationByDateTest(to, from);
//            if (listCompletedAudits.isEmpty()) {
//                oCompletedAuditResponse.setNumberofaudits("0");
//                return oCompletedAuditResponse;
//            }
//
//            for (Audit_Master oAudit_master : listCompletedAudits) {
//                CompletedAuditsTable tableDTO = new CompletedAuditsTable();
//                tableDTO.setAuditid(String.valueOf(oAudit_master.getId()));
//                tableDTO.setAudittype(oAudit_master.getType());
//
//                StationsDTO oStationDTO = oStationsService.getStationsById(oAudit_master.getStationCode());
//
//                if (!StringUtils.isEmpty(oStationDTO))
//                    tableDTO.setStationname(oStationDTO.getStationname());
//
//                List<UtilDTO> listUtilDTO = oUtilService.getAllRowsByValue(oAudit_master.getType());
//
//                if (!listUtilDTO.isEmpty())
//                    tableDTO.setAuditname(listUtilDTO.get(0).getPlaceholder_1());
//
//                tableDTO.setDuedate(oDateUtils.convertTimeStampToDate(oAudit_master.getCreatedTS(), "dd-MM-yyyy"));
//
//                if (!listCompletedAudits.isEmpty()) {
//                    tableDTO.setLastauditdate(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getCreatedTS(), "dd-MM-yyyy"));
//                } else {
//                    tableDTO.setLastauditdate("Not Applicable");
//                }
//
//                tableDTO.setStarttime(oDateUtils.convertTimeStampToDate(listCompletedAudits.get(0).getStartTime(), "dd-MM-yyyy"));
//
//                switch (oAudit_master.getType()) {
//                    case "ERBCONA":
//                        ERBCON++;
//                        break;
//                    case "ERBTECH":
//                        ERBTECH++;
//                        break;
//                    case "HSE":
//                        HSE++;
//                        break;
//                    case "FUEL":
//                        FUEL++;
//                        break;
//                }
//                listTableDTO.add(tableDTO);
//            }
//            oCompletedAuditResponse.setNumberofaudits(String.valueOf(listTableDTO.size()));
//            oCompletedAuditResponse.setNumberofERBCONAaudits(ERBCON.toString());
//            oCompletedAuditResponse.setNumberofERBTECHaudits(ERBTECH.toString());
//            oCompletedAuditResponse.setNumberofHSEaudits(HSE.toString());
//            oCompletedAuditResponse.setNumberofFUELaudits(FUEL.toString());
////            oCompletedAuditResponse.setFromdate(oDateUtils.parseDateToString(from));
////            oCompletedAuditResponse.setTodate(oDateUtils.parseDateToString(to));
//            oCompletedAuditResponse.setCompletedAuditList(listTableDTO);
//
////            for (StationsDTO station : listStationsDTO) {
//////                List<Audit_Master> listAudits = oAudit_MasterRepository.findAllAuditsForStation("Scheduled", station.getStationcode());
////                List<Audit_Master> listCompletedAudits = oAudit_MasterRepository.findAllAuditsForStation("Completed", station.getStationcode());
////                if (listCompletedAudits.isEmpty()) {
////                    oCompletedAuditResponse.setNumberofaudits("0");
////                    return oCompletedAuditResponse;
////                }
////
////
////            }
//        }
//        return oCompletedAuditResponse;
//    }

    @Override
    public List<Audit_MasterDTO> getAllPendingAudits(long loginUserId) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Audit_Master getAuditMasterByAuditId(long auditId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Audit_MasterDTO> getCompletedAudits(long loginUserId, int days) {
        List<Audit_MasterDTO> auditMasterDTOList = new ArrayList<>();
        // Calculate the date 'n' days ago
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(days);
        Date startDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        List<StationsDTO> listStationsDTO = oClustersService.getAllStationsForClusterManagerid(loginUserId);
        if (listStationsDTO.isEmpty())
            return auditMasterDTOList;

        List<String> stationCodeList = listStationsDTO.stream().map(StationsDTO::getStationcode).toList();

//        Pageable pageable = PageRequest.of(0, days); // Fetch only the last 'n' rows
        List<Audit_Master> auditMasterList = oAudit_MasterRepository.findLastNAudits(loginUserId, stationCodeList, startDate);

        auditMasterDTOList = auditMasterList.stream()
                .map(Audit_MasterMapper::maptoDTO)
                .toList();

        return auditMasterDTOList;
    }
}
