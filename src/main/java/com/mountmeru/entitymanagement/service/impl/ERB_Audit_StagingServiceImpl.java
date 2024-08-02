package com.mountmeru.entitymanagement.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mountmeru.entitymanagement.dto.ERB_Audit_StagingDTO;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Staging;
import com.mountmeru.entitymanagement.mapper.ERB_Audit_StagingMapper;
import com.mountmeru.entitymanagement.repository.ERB_Audit_MappingRepository;
import com.mountmeru.entitymanagement.repository.ERB_Audit_StagingRepository;
import com.mountmeru.entitymanagement.service.ERB_Audit_MappingService;
import com.mountmeru.entitymanagement.service.ERB_Audit_StagingService;
import com.mountmeru.entitymanagement.utils.DateUtils;

@Service
public class ERB_Audit_StagingServiceImpl implements ERB_Audit_StagingService{
	org.slf4j.Logger log = LoggerFactory.getLogger(ERB_Audit_StagingServiceImpl.class);	
	
	@Autowired 
	DateUtils oDateUtils;
	
	//@Autowired
	//Audit_MasterService oAudit_MasterService;
	
	@Autowired
	ERB_Audit_MappingService oERB_Audit_MappingService;
	
	@Autowired
	ERB_Audit_StagingRepository oRepository;
	
	@Autowired
	ERB_Audit_MappingRepository oMappingRepository;
	
	@Override
	public List<ERB_Audit_StagingDTO> createERBAuditStaging(List<ERB_Audit_StagingDTO> dtoList, long loginUserId) {
		List<ERB_Audit_StagingDTO> newDTOList = new ArrayList<ERB_Audit_StagingDTO>();
		log.info("Creating New User By {}", loginUserId );
		for( ERB_Audit_StagingDTO dto : dtoList)
		{
			ERB_Audit_Staging obj = ERB_Audit_StagingMapper.mapToObject(dto);
			obj.setCreatedBy(loginUserId);
			obj.setCreatedTS(oDateUtils.getCurrentTimeStamp());
			try {
				ERB_Audit_Staging savedRecord = oRepository.save(obj);
				newDTOList.add(ERB_Audit_StagingMapper.maptoDTO(savedRecord));
			}
			catch(Exception e)
			{
				log.error("Error while saving the record {}", e.getMessage());
				e.printStackTrace();
				throw new RuntimeErrorException(new Error(), "Exception occurred while creating ERB Audit Staging record.");
			}
		}
		return newDTOList;
	}

	@Override
	public List<ERB_Audit_StagingDTO> updateERBAuditStaging(List<ERB_Audit_StagingDTO> dtoList, long loginUserId) {

		List<ERB_Audit_StagingDTO> newDTOList = new ArrayList<ERB_Audit_StagingDTO>();
		log.info("Updated User By {}", loginUserId );
		for( ERB_Audit_StagingDTO dto1 : dtoList)
		{
			// Get the unique record.
			long audit_id = dto1.getAudit_id();
			int header = dto1.getHeader();
			int section = dto1.getSubheader();
			int addnotes = dto1.getAdditionalnotes();
			int question = dto1.getQuestion();
			
			ERB_Audit_Staging obj = oRepository.
					getOneByAuditIdHeaderSubHeaderAddNotesQuestion(audit_id, header, section, addnotes, question );
			
			if(!StringUtils.isEmpty(dto1.getPic_submitted_filename()))
				obj.setPIC_Submitted_FileName(dto1.getPic_submitted_filename());
			if(!StringUtils.isEmpty(dto1.getPic_submitted_filepath()))
				obj.setPIC_Submitted_FilePath(dto1.getPic_submitted_filepath());
			
			obj.setObtained_Score(dto1.getObtained_score());// Updating the score
			
			obj.setRemarks(dto1.getRemarks());
			obj.setComments(dto1.getComments());
			try {
				ERB_Audit_Staging savedRecord = oRepository.save(obj);
				newDTOList.add(ERB_Audit_StagingMapper.maptoDTO(savedRecord));
			}
			catch(Exception e)
			{
				log.error("Error while saving the record {}", e.getMessage());
				e.printStackTrace();
				throw new RuntimeErrorException(new Error(), "Exception occurred while creating ERB Audit Staging record.");
			}
		}
		return newDTOList;	
	}
}
