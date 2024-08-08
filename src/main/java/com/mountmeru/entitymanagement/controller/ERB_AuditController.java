package com.mountmeru.entitymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mountmeru.entitymanagement.dto.Audit_MasterDTO;
import com.mountmeru.entitymanagement.dto.ERB_Audit_StagingDTO;
import com.mountmeru.entitymanagement.dto.UtilDTO;
import com.mountmeru.entitymanagement.jsonresponses.ERB_Audit_Initial_LoadResponse;
import com.mountmeru.entitymanagement.jsonresponses.ERB_Audit_ScoreCardResponse;
import com.mountmeru.entitymanagement.service.ERB_Audit_MappingService;
import com.mountmeru.entitymanagement.service.ERB_Audit_StagingService;
import com.mountmeru.entitymanagement.service.ScorecardService;
import com.mountmeru.entitymanagement.service.UtilService;

@RestController
@RequestMapping("/api/erbaudit")
public class ERB_AuditController {
	@Autowired 
	ERB_Audit_MappingService oERB_Audit_Mapping;  
	
	@Autowired
	UtilService oUtilService; 
	
	@Autowired
	ERB_Audit_StagingService oERB_Audit_StagingService;
	
	@Autowired 
	ScorecardService oScorecardService;
	
	@PostMapping("/loaddata")
	public ResponseEntity<ERB_Audit_Initial_LoadResponse> loadData(@RequestBody Audit_MasterDTO audit_masterDTO, @RequestHeader long loginUserId)
	{
		// TODO - Validate LoginUserid.
		return new ResponseEntity<>(oERB_Audit_Mapping.getAllRequiredDataForERBAudit(audit_masterDTO.getId()), HttpStatus.OK);
	}	
	@PostMapping("/loadutildata")
	public ResponseEntity<List<UtilDTO>> loadUtilDate(@RequestBody UtilDTO oUtilDTO, @RequestHeader long loginUserId)
	{
		// TODO - Validate LoginUserid.
		return new ResponseEntity<>(oUtilService.getAllRowsByType(oUtilDTO.getType()), HttpStatus.CREATED);
	}
	@PostMapping("/createerbaudit")
	public ResponseEntity<List<ERB_Audit_StagingDTO>> createerbaudit(@RequestBody List<ERB_Audit_StagingDTO> listStagingDTO, @RequestHeader long loginUserId)
//	public ResponseEntity<List<ERB_Audit_StagingDTO>> createerbaudit(@RequestBody ERB_Audit_StagingDTO listStagingDTO, @RequestHeader long loginUserId)
	{
		// TODO - Validate LoginUserid.
		return new ResponseEntity<>(oERB_Audit_StagingService.createERBAuditStaging(listStagingDTO, loginUserId), HttpStatus.CREATED);
	}
	@PutMapping("/updateerbaudit")
	public ResponseEntity<List<ERB_Audit_StagingDTO>> updateerbaudit(@RequestBody List<ERB_Audit_StagingDTO> listStagingDTO, @RequestHeader long loginUserId)
	{
		// TODO - Validate LoginUserid.
		return new ResponseEntity<>(oERB_Audit_StagingService.updateERBAuditStaging(listStagingDTO, loginUserId), HttpStatus.CREATED);
	}
	@PutMapping("/uploadimageforerbaudit")
	public ResponseEntity<List<ERB_Audit_StagingDTO>> uploadimageforerbaudit(@RequestBody List<ERB_Audit_StagingDTO> listStagingDTO, @RequestHeader long loginUserId)
	{
		// TODO - Validate LoginUserid.
		return new ResponseEntity<>(oERB_Audit_StagingService.updateERBAuditStaging(listStagingDTO, loginUserId), HttpStatus.CREATED);
	}
	@PostMapping("/geterbscorecard")
	public ResponseEntity<ERB_Audit_ScoreCardResponse> geterbscorecard(@RequestBody long audit_id, @RequestHeader long loginUserId)
	{
		// TODO - Validate LoginUserid.
		return new ResponseEntity<>(oScorecardService.getERBConsumerAuditScoreCard(audit_id, loginUserId), HttpStatus.CREATED);
	}
}
