package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.UsersDTO;
import com.mountmeru.entitymanagement.entity.Users;
@Service 
public class UsersMapper {
	public static Users maptoUsers(UsersDTO usersDTO)
	{
		Users users = new Users(
				usersDTO.getCounter(),
				usersDTO.getCreatedts(),
				usersDTO.getUpdatedts(),
				usersDTO.getCreatedby(),
				usersDTO.getUpdatedby(),
				usersDTO.getId(),
				usersDTO.getRole(),
				usersDTO.getFirstname(),
				usersDTO.getMiddlename(),
				usersDTO.getLastname(),				
				usersDTO.getEmail(),				
				usersDTO.getPhone1(),
				usersDTO.getPhone2(),
				usersDTO.getDesignation(),
				usersDTO.getStatus()
				);
		return users;
	}
	
	public static UsersDTO maptoUsersDTO(Users Users)
	{
		UsersDTO usersDTO = new UsersDTO(
				Users.getCounter(),
				Users.getCreatedTS(),
				Users.getUpdatedTS(),
				Users.getCreatedBy(),
				Users.getUpdatedBy(),					
				Users.getId(),
				Users.getRole(),				
				Users.getFirstName(),
				Users.getMiddleName(),
				Users.getLastName(),				
				Users.getEMail(),
				Users.getPhone1(),
				Users.getPhone2(),
				Users.getDesignation(),
				Users.getStatus()
				); 
		return usersDTO;
	}
}