package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.UserLoginDTO;
import com.mountmeru.entitymanagement.entity.UserLogin;

@Service   
public class UserLoginMapper {

	public static UserLogin mapToObject(UserLoginDTO userLoginDTO)
	{
		UserLogin userLogin = new UserLogin(
				userLoginDTO.getCounter(),
				userLoginDTO.getId(),
				userLoginDTO.getOtp(), 
				userLoginDTO.getCreatedts(), 
				userLoginDTO.getLoginsuccessful()
				);
		return userLogin; 
	}	
	public static UserLoginDTO maptoRolesDTO(UserLogin oUserLogin)
	{
		UserLoginDTO oUserLoginDTO = new UserLoginDTO( 
				oUserLogin.getCounter(),
				oUserLogin.getId(),
				oUserLogin.getOtp(),
				oUserLogin.getLogin_Successful(),
				oUserLogin.getCreatedTs()
				);		 
		return oUserLoginDTO;
	}
}
