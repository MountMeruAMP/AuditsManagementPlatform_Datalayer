package com.mountmeru.entitymanagement.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mountmeru.entitymanagement.dto.Audit_MasterDTO;
import com.mountmeru.entitymanagement.dto.ERB_Audit_MappingDTO;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Mapping;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Staging;
import com.mountmeru.entitymanagement.entity.Stations;
import com.mountmeru.entitymanagement.jsonresponses.ERB_Audit_Initial_LoadDataResponse;
import com.mountmeru.entitymanagement.jsonresponses.ERB_Audit_Initial_LoadResponse;
import com.mountmeru.entitymanagement.mapper.Audit_MasterMapper;
import com.mountmeru.entitymanagement.mapper.ERB_Audit_MappingMapper;
import com.mountmeru.entitymanagement.repository.Audit_MasterRepository;
import com.mountmeru.entitymanagement.repository.ERB_Audit_MappingRepository;
import com.mountmeru.entitymanagement.repository.ERB_Audit_StagingRepository;
import com.mountmeru.entitymanagement.repository.StationsRepository;
import com.mountmeru.entitymanagement.service.ERB_Audit_MappingService;
import com.mountmeru.entitymanagement.service.UtilService;

@Service
public class ERB_Audit_MappingServiceImpl implements ERB_Audit_MappingService{

	private String delimiter = ":";
	@Autowired
	ERB_Audit_MappingRepository oERB_Audit_MappingRepository;
	
	@Autowired
	UtilService oUtilService;	
	
	@Autowired
	Audit_MasterRepository amrepo;
	
	@Autowired
	StationsRepository stRepo;
	
	@Autowired
	ERB_Audit_StagingRepository oERB_Audit_StagingRepository;
	 
	@Override
	public List<ERB_Audit_MappingDTO> getAllQuestionsForAudit(String strAuditType) {
		List<ERB_Audit_MappingDTO> listERB_Audit_MappingDTO = new LinkedList<ERB_Audit_MappingDTO>();
		List<ERB_Audit_Mapping>  listERB_Audit_Mapping =   oERB_Audit_MappingRepository.findAllTestForAudit(strAuditType);
		for(ERB_Audit_Mapping oERB_Audit_Mapping :listERB_Audit_Mapping)
		{
			listERB_Audit_MappingDTO.add(ERB_Audit_MappingMapper.maptoRolesDTO(oERB_Audit_Mapping));
		}
		return listERB_Audit_MappingDTO;				
	}

	@Override
	public ERB_Audit_Initial_LoadResponse getAllRequiredDataForERBAudit(long auditId) {
		// TODO Auto-generated method stub
		Map <String, String> storedResponses  = new HashMap<String, String>();
		boolean isUpdateFlow = false;
		ERB_Audit_Initial_LoadResponse oERB_Audit_InitResponse =  new ERB_Audit_Initial_LoadResponse();
		Audit_MasterDTO dto = getAuditMasterByAuditId(auditId);
		oERB_Audit_InitResponse.setoAudit_MasterDTO(dto);
		oERB_Audit_InitResponse.setTransaction("Create");
		List<ERB_Audit_Initial_LoadDataResponse> listERB_Audit_MappingDTO = new LinkedList<ERB_Audit_Initial_LoadDataResponse>();
		List<ERB_Audit_Mapping>  listERB_Audit_Mapping =   oERB_Audit_MappingRepository.findAllTestForAudit(dto.getType());
		List<ERB_Audit_Staging> listERB_Audit_Staging = oERB_Audit_StagingRepository.findAllRecordsByAuditId( auditId);	
		if(!listERB_Audit_Staging.isEmpty())
		{
			oERB_Audit_InitResponse.setTransaction("Update");
			isUpdateFlow = true;
			for(ERB_Audit_Staging oERB_Audit_Staging : listERB_Audit_Staging)
			{
				storedResponses.put(oERB_Audit_Staging.getHeader()+delimiter+oERB_Audit_Staging.getSub_Header()+delimiter+
						oERB_Audit_Staging.getAdditional_Notes()+delimiter+oERB_Audit_Staging.getQuestion(),
				oERB_Audit_Staging.getObtained_Score()+delimiter+oERB_Audit_Staging.getRemarks()+delimiter+oERB_Audit_Staging.getComments());
			}
		}
		
		for(ERB_Audit_Mapping oERB_Audit_Mapping :listERB_Audit_Mapping)
		{
			ERB_Audit_Initial_LoadDataResponse oResp = new ERB_Audit_Initial_LoadDataResponse();
			oResp.setoERB_Audit_MappingDTO(ERB_Audit_MappingMapper.maptoRolesDTO(oERB_Audit_Mapping));
			if(isUpdateFlow)
			{
				if(storedResponses.containsKey(oERB_Audit_Mapping.getHeader()+delimiter+oERB_Audit_Mapping.getSub_Header()
				+delimiter+oERB_Audit_Mapping.getAdditional_Notes()+delimiter+oERB_Audit_Mapping.getQuestion()))
				{
					String savedData = storedResponses.get(oERB_Audit_Mapping.getHeader()+delimiter+oERB_Audit_Mapping.getSub_Header()
					+delimiter+oERB_Audit_Mapping.getAdditional_Notes()+delimiter+oERB_Audit_Mapping.getQuestion());
					if (!StringUtils.isEmpty(savedData))
					{
						String[] splittedRepose = savedData.split(delimiter);
						oResp.setSavedscore(splittedRepose[0]);
						oResp.setSavedremark(splittedRepose[1]);
						oResp.setSavedcomment(splittedRepose[2]);
					}
				}
			}
			listERB_Audit_MappingDTO.add(oResp);
		}
		oERB_Audit_InitResponse.setListERB_Audit_MappingDTO(listERB_Audit_MappingDTO); 
		oERB_Audit_InitResponse.setListUtilDTO(oUtilService.getAllRowsByType(dto.getType()));		
		Stations stn = stRepo.findStationByStationCode(dto.getStationcode());
		oERB_Audit_InitResponse.setLatitude(stn.getLATI());
		oERB_Audit_InitResponse.setLongitude(stn.getLONGI());
		return oERB_Audit_InitResponse;
	}
	private Audit_MasterDTO  getAuditMasterByAuditId(long auditId) {
		return Audit_MasterMapper.maptoDTO(amrepo.getOneByAuditId(auditId));
	}
	// Audit Type Values : 
	// ERBCONA : ERB Consumer Audit
	// ERBTECH : ERB Technical Audit	

	@Override
	public List<ERB_Audit_Mapping> getRecordsByHeaderSubHeaderAddInfoQuestions(String strAuditType, int header,
			int subheader, int addnotes, int question) {
		// TODO Auto-generated method stub
		return oERB_Audit_MappingRepository.findAllByHeaderSubHeaderAddNotesQuestion( strAuditType, header,subheader,addnotes, question);
	}

	@Override
	public List<ERB_Audit_Mapping> getRecordsByHeaderSubHeaderAddInfoNotQuestions(String strAuditType, int header,
			int subheader, int addnotes, int question) {
		// TODO Auto-generated method stub
		return oERB_Audit_MappingRepository.findAllByHeaderSubHeaderAddNotesNotQuestion( strAuditType, header,subheader,addnotes, question);
	}

	@Override
	public List<ERB_Audit_Mapping> getRecordsByHeaderNotSubHeaderNotQuestions(String strAuditType, int header,
			int subheader, int addnotes, int question) {
		// TODO Auto-generated method stub
		return oERB_Audit_MappingRepository.findAllByHeaderSubHeaderAddNotesNotQuestion( strAuditType, header,subheader,addnotes, question);
	}
}
