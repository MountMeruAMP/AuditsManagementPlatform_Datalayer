package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.RolesDTO;
import com.mountmeru.entitymanagement.entity.Roles;
@Service    
public class RolesMapper {
	public static Roles mapToRoles(RolesDTO rolesDTO)
	{
		Roles roles = new Roles(
				rolesDTO.getCounter(),
				rolesDTO.getCreatedts(),
				rolesDTO.getUpdatedts(),
				rolesDTO.getCreatedby(),
				rolesDTO.getUpdatedby(),				
				rolesDTO.getId(),
				rolesDTO.getRolename(),
				rolesDTO.getRoleshortname(),
				rolesDTO.getStatus(),
				rolesDTO.getRemark()
				);
		return roles; 
	}	
	public static RolesDTO maptoRolesDTO(Roles roles)
	{
		RolesDTO rolesDTO = new RolesDTO( 
				roles.getCounter(),
				roles.getCreatedTS(),
				roles.getUpdatedTS(),
				roles.getCreatedBy(),
				roles.getUpdatedBy(),				
				roles.getId(),
				roles.getRoleName(),
				roles.getRoleShortName(),
				roles.getStatus(),
				roles.getRemark()
				);		
		return rolesDTO;
	}
}
