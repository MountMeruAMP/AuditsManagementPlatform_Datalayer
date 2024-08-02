package com.mountmeru.entitymanagement.service;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.UsersDTO;

@Service
public interface UserLoginService {	
	String generateOTP(long Userid);
	UsersDTO validateUserForUserIdAndOTP(long UserId, String OTP);
}
