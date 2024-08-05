package com.mountmeru.entitymanagement.controller;

import com.mountmeru.entitymanagement.jsonresponses.CompletedAuditResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mountmeru.entitymanagement.dto.Audit_MasterDTO;
import com.mountmeru.entitymanagement.jsonresponses.UpcomingAuditsResponse;
import com.mountmeru.entitymanagement.service.Audit_MasterService;

@RestController
@RequestMapping("/api/auditmaster")
public class Audit_MasterController {
	@Autowired
	Audit_MasterService oAudit_MasterService;
 
	// Add New Users REST API.
	@PostMapping("/createaudit")
	public ResponseEntity<Audit_MasterDTO> createAuditMaster(@RequestBody Audit_MasterDTO auditmasterDTO, @RequestHeader long loginUserId)
	{
		return new ResponseEntity<>(oAudit_MasterService.createAuditMaster(auditmasterDTO, loginUserId), HttpStatus.CREATED);
	}	
	@PostMapping("/updateaudit")
	public ResponseEntity<Audit_MasterDTO> updateAuditMaster(@RequestBody Audit_MasterDTO auditmasterDTO, @RequestHeader long loginUserId)
	{
		return new ResponseEntity<>(oAudit_MasterService.updateAuditMaster(auditmasterDTO, loginUserId), HttpStatus.OK);
	}
	@PostMapping("/submitaudit")
	public ResponseEntity<Audit_MasterDTO> submitAudit(@RequestBody Audit_MasterDTO auditmasterDTO, @RequestHeader long loginUserId)
	{
		return new ResponseEntity<>(oAudit_MasterService.submitAudit(auditmasterDTO, loginUserId), HttpStatus.OK);
	}
	@PostMapping("/uploadfinaldocument")
	public ResponseEntity<Audit_MasterDTO> uploadFinalAuditDocuments(@RequestBody Audit_MasterDTO auditmasterDTO, @RequestHeader long loginUserId)
	{
		return new ResponseEntity<>(oAudit_MasterService.uploadFinalAuditDocuments(auditmasterDTO, loginUserId), HttpStatus.OK);
	}
	
	@GetMapping("/getallupcomingaudits") 
	public ResponseEntity<UpcomingAuditsResponse> getAllUpcomingAudits(@RequestHeader long loginUserId)
	{
		// TODO - Validate LoginUserid.
		return new ResponseEntity<>(oAudit_MasterService.getAllUpComingAudits(loginUserId), HttpStatus.CREATED);
	} 
	/*
	 * @GetMapping("/getallcompletedaudits") public
	 * ResponseEntity<List<Audit_MasterDTO>> getAllCompletedAudits(@RequestHeader
	 * long loginUserId) { List<Audit_MasterDTO> listAudits = new
	 * ArrayList<Audit_MasterDTO>(); return new ResponseEntity<>(listAudits),
	 * HttpStatus.OK); }
	 */

	@GetMapping("/getallcompletedaudits")
	public ResponseEntity<CompletedAuditResponse> getAllCompletedAudits(@RequestHeader long loginUserId,
																		@RequestParam(name = "from", required = false) String fromDate,
																		@RequestParam(name = "to", required = false)String toDate) {
		// TODO - Validate LoginUserid.
		return new ResponseEntity<>(oAudit_MasterService.getAllCompletedAudits(loginUserId, fromDate, toDate), HttpStatus.OK);
	}
}
