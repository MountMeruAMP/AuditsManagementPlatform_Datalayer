package com.mountmeru.entitymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.RolesDTO;


@Service
public interface RolesService {
	RolesDTO createRole(RolesDTO role, long loginUserId);
	RolesDTO updateRole(RolesDTO role, long loginUserId);
	String deleteRole(long roleId);
	RolesDTO getRoleById(long roleid);
	List<RolesDTO> getAllRoles();
	
} 
