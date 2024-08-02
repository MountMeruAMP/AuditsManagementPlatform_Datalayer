package com.mountmeru.entitymanagement.component;

import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mountmeru.entitymanagement.dto.Audit_MasterDTO;
import com.mountmeru.entitymanagement.dto.StationsDTO;
import com.mountmeru.entitymanagement.dto.UtilDTO;
import com.mountmeru.entitymanagement.entity.Audit_Master;
import com.mountmeru.entitymanagement.entity.Users;
import com.mountmeru.entitymanagement.repository.Audit_MasterRepository;
import com.mountmeru.entitymanagement.repository.UsersRepository;
import com.mountmeru.entitymanagement.service.Audit_MasterService;
import com.mountmeru.entitymanagement.service.StationsService;
import com.mountmeru.entitymanagement.service.UtilService;
import com.mountmeru.entitymanagement.utils.Constants;
import com.mountmeru.entitymanagement.utils.DateUtils; 

@Component
public class ScheduleAllAudits {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ScheduleAllAudits.class);
	
	@Value("${application.audit.mindays}")
	String auditmindays;
	
	@Value("${application.audit.maxdays}")
	String auditmaxdays;
	
	@Autowired
	DateUtils oDateUtils;
	
	@Autowired
	UtilService oUtilService;
	
	@Autowired 
	StationsService oStationService;
	
	@Autowired 
	Audit_MasterRepository oAuditMastRepo;
	
	@Autowired
	Audit_MasterService oAudit_MasterService;
	
	@Autowired 
	UsersRepository oUsersRepository;
	
	int audit_counter = 0;
	
	@Scheduled(cron = "${application.scheduler.croninterval}")
	public void scheduleAllAuditsImpl()
	{
		log.info("scheduleAllAuditsImpl() method execution started by the scheduler...... ");
		// Get all Stations in the System.
		List<StationsDTO> listStations =  oStationService.getAllStations();
		List<UtilDTO>  listAuditTypes = oUtilService.getAllRowsByType(Constants.auditType);
		for(StationsDTO oStation: listStations)
		{
			scheduleAuditForStation(oStation, listAuditTypes);
		}
	}
	/**
	 * This method schedules audits for a Station as per the logic.
	 * @param stationCode
	 * @param listAuditTypes
	 */
	public void scheduleAuditForStation(StationsDTO station,List<UtilDTO>  listAuditTypes)
	{
		String stationCode = station.getStationcode();
		// Get Previously scheduled audit for an Audit Type
		for(UtilDTO oAuditTypes : listAuditTypes)
		{
			String auditType = oAuditTypes.getValue();
			List<Audit_Master> listAudits =   oAuditMastRepo.
					findAllAuditsForStationAndAuditType(stationCode, auditType);
			if(listAudits.isEmpty())
			{
				Users[] auditorUsers = oUsersRepository.findByRole(1008);				
				// No Audit is created for this station and type till now.
				// Schedule the Audit Now.
				Date newScheduledDate = new Date();				
				Audit_MasterDTO auditDTO = new Audit_MasterDTO();				
				auditDTO.setStationcode(stationCode);
				auditDTO.setId(generateAuditId(newScheduledDate));
				auditDTO.setType(auditType);
				auditDTO.setState(Constants.audit_state_scheduled);
				auditDTO.setAuditor(auditorUsers[0].getId());
				auditDTO.setWitness(Long.parseLong(station.getManager_id()));
				auditDTO.setStatus(Constants.audit_state_scheduled);
				auditDTO.setStarttime(null);
				auditDTO.setEndtime(null);
				auditDTO.setAuditor_signature(null);
				auditDTO.setWitness_signature(null);
				auditDTO.setRemarks("");
				auditDTO.setDoc_submitted_filename("");
				auditDTO.setDoc_submitted_filepath("");
				auditDTO.setDoc_uploaded_filename("");
				auditDTO.setDoc_uploaded_filepath("");
				auditDTO.setScheduled_date(newScheduledDate);
				auditDTO.setGroup("");
				Audit_MasterDTO oAuditMasterDTO = oAudit_MasterService.createAuditMaster(auditDTO, 0);
				log.info("New Audit is Created with details {}", oAuditMasterDTO);
			}
			else
			{
				Audit_Master oPreviousAudit =  listAudits.get(0);
				// Check for minium Number of days before scheduling.
				Date previousAuditDate = oPreviousAudit.getScheduled_Date();
				
				String dateToSchedule = oDateUtils.addDaysToDateReturnString(previousAuditDate,Integer.parseInt(auditmindays)+1); 
				String todaysDate =  oDateUtils.getTodaysDateAsString();
				Date newScheduledDate = oDateUtils.addDaysToDateReturnDate(previousAuditDate,Integer.parseInt(auditmindays)); 
				if(oDateUtils.getDatefromDate(newScheduledDate) == 1)
				{
					newScheduledDate = oDateUtils.addDaysToDateReturnDate(previousAuditDate,Integer.parseInt(auditmindays)+1); 
				}
				if(dateToSchedule.equals(todaysDate))
				{
					// We are good to schedule.
					// If auditmindays = 25 then Creating new Audit on 26th day.
					
					Audit_MasterDTO auditDTO = new Audit_MasterDTO();
					
					auditDTO.setStationcode(stationCode);
					auditDTO.setId(generateAuditId(newScheduledDate));
					auditDTO.setType(auditType);
					auditDTO.setState(Constants.audit_state_scheduled);
					auditDTO.setAuditor(oPreviousAudit.getAuditor());
					auditDTO.setWitness(oPreviousAudit.getWitness());
					auditDTO.setStatus(Constants.audit_state_scheduled);
					auditDTO.setStarttime(null);
					auditDTO.setEndtime(null);
					auditDTO.setAuditor_signature(null);
					auditDTO.setWitness_signature(null);
					auditDTO.setRemarks("");
					auditDTO.setDoc_submitted_filename("");
					auditDTO.setDoc_submitted_filepath("");
					auditDTO.setDoc_uploaded_filename("");
					auditDTO.setDoc_uploaded_filepath("");
					auditDTO.setScheduled_date(newScheduledDate);
					auditDTO.setGroup("");
					Audit_MasterDTO oAuditMasterDTO = oAudit_MasterService.createAuditMaster(auditDTO, 0);
					log.info("New Audit is Created with details {}", oAuditMasterDTO);
				}
			}
		}
	}
	
	public long generateAuditId(Date newScheduledDate)
	{		
		audit_counter++;
		String newDate = oDateUtils.convertTimeStampToDate(newScheduledDate, "ddMMyyyy")+String.valueOf(audit_counter); ;
		try {
			return Long.parseLong(newDate);
		}
		catch(Exception e)
		{
			return (long)(Math.random()*100000 + 3333300000L);
		}
	}
}
