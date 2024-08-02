package com.mountmeru.entitymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mountmeru.entitymanagement.dto.UsersDTO;
import com.mountmeru.entitymanagement.jsonrequests.UserLoginRequest;
import com.mountmeru.entitymanagement.jsonrequests.UserRequest;
import com.mountmeru.entitymanagement.service.UserLoginService;
import com.mountmeru.entitymanagement.service.UsersService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	UserLoginService userLoginService;
	
	@PostMapping(value = "/prevalidateuser", produces ="application/json")
	public ResponseEntity<UsersDTO> preLoginRequest(@RequestBody UserRequest userRequest) throws RuntimeException
	{
		UsersDTO usersDTO = usersService.getUsersByUserId(userRequest.getId());
		return ResponseEntity.ok(usersDTO);
	}
	@PostMapping(value = "/generateotp", produces ="application/json")
	public ResponseEntity<String> generateOTP(@RequestBody UserRequest userRequest)
	{
		userLoginService.generateOTP(userRequest.getId());
		return  ResponseEntity.status(HttpStatus.OK).body("OTP generated and sent to the User Registered Phone Number.");
	}
	@PostMapping(value = "/validateuserotp", produces ="application/json")
	public ResponseEntity<UsersDTO> validateUserAndOTP(@RequestBody UserLoginRequest userLogin)
	{		
		return new ResponseEntity<>(userLoginService.validateUserForUserIdAndOTP(userLogin.getId(), userLogin.getOtp()), HttpStatus.OK);
	}
}
