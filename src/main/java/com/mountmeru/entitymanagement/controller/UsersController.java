package com.mountmeru.entitymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mountmeru.entitymanagement.dto.UsersDTO;
import com.mountmeru.entitymanagement.service.UsersService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	UsersService usersService;

	public UsersController(UsersService usersService)
	{
		this.usersService = usersService;
	}
	// Add New Users REST API.
	@PostMapping("/createuser")
	public ResponseEntity<UsersDTO> addNewUser(@RequestBody UsersDTO usersDTO, @RequestHeader String loginUserId)
	{
		long userId = Long.valueOf(loginUserId);
		return new ResponseEntity<>(usersService.createUser(usersDTO, userId), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UsersDTO> getUserById(@PathVariable long id)
	{
		UsersDTO usersDTO = usersService.getUsersByCounter(id);
		return ResponseEntity.ok(usersDTO);
	}
	@GetMapping("/getUserById")
	public ResponseEntity<UsersDTO> getUserByUserId(@RequestHeader long userId)
	{
		UsersDTO usersDTO = usersService.getUsersByUserId(userId);
		return ResponseEntity.ok(usersDTO);
	}
	@PostMapping("/updateuser")
	public ResponseEntity<UsersDTO> updateUser(@RequestBody UsersDTO usersDTO, @RequestHeader long loginUserId)
	{
		return new ResponseEntity<>(usersService.updateUser(usersDTO, loginUserId), HttpStatus.OK);
	}
}
