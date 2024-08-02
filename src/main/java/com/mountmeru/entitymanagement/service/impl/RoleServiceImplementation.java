package com.mountmeru.entitymanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.RolesDTO;
import com.mountmeru.entitymanagement.entity.Roles;
import com.mountmeru.entitymanagement.mapper.RolesMapper;
import com.mountmeru.entitymanagement.repository.RolesRepository;
import com.mountmeru.entitymanagement.service.RolesService;
import com.mountmeru.entitymanagement.utils.DateUtils;



@Service
public class RoleServiceImplementation implements RolesService{

	@Autowired 
	DateUtils oDateUtils;
	
	private RolesRepository rolesRepository;
	
	
	public RoleServiceImplementation(RolesRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}
	@Override
	public RolesDTO createRole(RolesDTO roleDTO, long loginUserId) {
		// TODO Auto-generated method stub
		validateDuplicateRoleId(roleDTO.getId());
		Roles roles = RolesMapper.mapToRoles(roleDTO);
		
		// Setting the mandatory fields.
		roles.setCreatedTS(oDateUtils.getCurrentTimeStamp());
		roles.setUpdatedTS(null);
		roles.setCreatedBy(loginUserId);		
		try {
			Roles savedRoles = rolesRepository.save(roles);
			return RolesMapper.maptoRolesDTO(savedRoles);
		}
		catch(Exception e)
		{
			throw new RuntimeErrorException(new Error("Exception occurred while creating the Role."));
		}		
	}
	@Override
	public RolesDTO getRoleById(long roleid) {
		
		Roles roles = rolesRepository
				.findById(roleid)				
				.orElseThrow(() -> new RuntimeException("Role does not exists"));
		return RolesMapper.maptoRolesDTO(roles);
	}
	@Override
	public List<RolesDTO> getAllRoles()
	{		
		List<Roles> roles = rolesRepository.findAll();		
		List<RolesDTO> listRolesDTO = new ArrayList<RolesDTO>();
		for(Roles role: roles)
		{
			listRolesDTO.add(RolesMapper.maptoRolesDTO(role));
		}
		return listRolesDTO;		
	}
	@Override
	public RolesDTO updateRole(RolesDTO roleDTO, long loginUserId) {
		RolesDTO roleDTONew =  getRoleById(roleDTO.getId());
		
		Roles roles = RolesMapper.mapToRoles(roleDTONew);
				
		// Setting the mandatory fields.		
		roles.setUpdatedTS(oDateUtils.getCurrentTimeStamp());
		roles.setUpdatedBy(loginUserId);

		// Saving the role.
		try {
			Roles savedRoles = rolesRepository.save(roles);
			return RolesMapper.maptoRolesDTO(savedRoles);
		}
		catch(Exception e)
		{
			throw new RuntimeErrorException(new Error("Exception occurred while updating the Role."));
		}
	}
	@Override
	public String  deleteRole(long roleId) {
		// TODO Auto-generated method stub
		if(null != getRoleById(roleId))
		{
			rolesRepository.deleteById(roleId);
			return "Success";
		}
		else
		{
			return "Failure";
		}		
	}
	private void validateDuplicateRoleId(long roleId)
	{
		if(null != getRoleById(roleId))
		{
			throw new RuntimeErrorException(new Error("Duplicate Role Id."));
		}
		return;
	}
}
