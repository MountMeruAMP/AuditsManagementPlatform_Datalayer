package com.mountmeru.entitymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mountmeru.entitymanagement.dto.RolesDTO;
import com.mountmeru.entitymanagement.service.RolesService;




@RestController
@RequestMapping("/api/roles")
public class RolesController {

	@Autowired
	private RolesService rolesService;

	public RolesController(RolesService rolesService)
	{
		this.rolesService = rolesService;
	}

	// Add New Roles REST API.
	@PostMapping(value = "/createrole", produces ="application/json")
	public ResponseEntity<RolesDTO> addNewRole(@RequestBody RolesDTO rolesDTO, @RequestHeader long loginUserId)
	{
		return new ResponseEntity<>(rolesService.createRole(rolesDTO, loginUserId), HttpStatus.CREATED);
	}

	// Get the role by ID
	@GetMapping( value = "/getrolebyid", produces ="application/json")
	public ResponseEntity<RolesDTO> getRoleById(@RequestHeader long id)
	{
		RolesDTO rolesDTO = rolesService.getRoleById(id);
		return  ResponseEntity.ok(rolesDTO);
	}

	// Get the role by ID
	@GetMapping(value ="/getallroles", produces ="application/json")
	public ResponseEntity<List<RolesDTO>> getAllRoles()
	{
		List<RolesDTO> listRolesDTO = rolesService.getAllRoles();
		return new ResponseEntity<>(listRolesDTO, HttpStatus.OK);
	}
	// Update Existing  Roles REST API.
	@PutMapping(value = "/updaterole", produces ="application/json")
	public ResponseEntity<RolesDTO> updateRole(@RequestBody RolesDTO rolesDTO, @RequestHeader long loginUserId)
	{	
		try {
			return new ResponseEntity<>(rolesService.updateRole(rolesDTO, loginUserId), HttpStatus.CREATED);
		}
		catch( Exception e)
		{
			return new ResponseEntity<>(rolesDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	@PutMapping(value = "/deleterole", produces ="application/json")
	public ResponseEntity<String> deleteRole(@RequestBody RolesDTO rolesDTO) {
		long roleId = rolesDTO.getId();
		if("Success".equals(rolesService.deleteRole(roleId)))
			return  ResponseEntity.status(HttpStatus.OK).body("Role record deleted successfully");
		else
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Role record deleted un-successfully");
	}
}
