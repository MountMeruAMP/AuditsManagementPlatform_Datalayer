package com.mountmeru.entitymanagement.service.impl;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.UsersDTO;
import com.mountmeru.entitymanagement.entity.Users;
import com.mountmeru.entitymanagement.exceptions.RoleNotFoundException;
import com.mountmeru.entitymanagement.exceptions.UserLoginException;
import com.mountmeru.entitymanagement.mapper.UsersMapper;
import com.mountmeru.entitymanagement.repository.UsersRepository;
import com.mountmeru.entitymanagement.service.UsersService;
import com.mountmeru.entitymanagement.utils.DateUtils;
import com.mountmeru.entitymanagement.validators.UserValidator;

@Service
public class UserServiceImplementation implements UsersService{

	org.slf4j.Logger log = LoggerFactory.getLogger(UserServiceImplementation.class);
		 
	@Autowired
	DateUtils oDateUtils; 
	
	@Autowired 
	UserValidator oUserValidator;
	
	private UsersRepository usersRepository;
	
	public UserServiceImplementation(UsersRepository usersRepository)
	{
		this.usersRepository = usersRepository; 
	}
	
	@Override
	public UsersDTO createUser(UsersDTO usersDTO, long loginUserId) {	
		log.info("Creating New User By {}", loginUserId );
		// 0. Validate the inputd for the User.
		oUserValidator.validateUser(usersDTO);		
		Users users = UsersMapper.maptoUsers(usersDTO); 		// 0. Validate necessary fields for the user. 
		
		log.info("All Validations Done {}", loginUserId );		
		users.setCreatedTS(oDateUtils.getCurrentTimeStamp());
		users.setUpdatedTS(null);
		users.setCreatedBy(loginUserId);		
		
		log.debug("Saving the record.");	 
		try {
		Users savedUser = usersRepository.save(users);
		return UsersMapper.maptoUsersDTO(savedUser);	
		}
		catch(Exception e)
		{
			log.error("Error while saving the record {}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeErrorException(new Error(), "Exception occurred while creating User record.");
		}
	}

	@Override
	public UsersDTO getUsersByCounter(long id) {
		usersRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("User Does Not Exist"));
		return null;
	}

	@Override
	public UsersDTO getUsersByUserId(long userId) {
		// Use Custom queries here to fetch the User record.
		Users[]  aUser = usersRepository.findByUserId(userId); 
		if(null == aUser || aUser.length == 0 || null== aUser[0])
			throw new UserLoginException("User Does Not Exist");
		else {
			return UsersMapper.maptoUsersDTO(aUser[0]);
		}		
	}
	
	@Override
	public UsersDTO updateUser(UsersDTO usersDTO, long loginUserId) {
		// TODO Auto-generated method stub
		log.info("Updating user By {}", loginUserId);
		Users[]  aUser = usersRepository.findByUserId(usersDTO.getId());
		if(null == aUser || aUser.length ==0 || null != aUser[0])
		{
			log.error("Record not found {}", usersDTO.getId());
			throw new RuntimeErrorException(new Error(), "User doesn not exist");
		}
		// Setting the mandatory Fields.
		Users newUser = UsersMapper.maptoUsers(usersDTO);
		newUser.setUpdatedTS(oDateUtils.getCurrentTimeStamp());
		newUser.setUpdatedBy(loginUserId);
		log.debug("Saving the record in the database");
		try {
			Users savedUser = usersRepository.save(newUser);
			return UsersMapper.maptoUsersDTO(savedUser);	
		}
		catch(Exception e)
		{
			log.error("Error while updating the record {}", e.getMessage());
			e.printStackTrace();
			throw new RuntimeErrorException(new Error(), "Exception occurred while updating User record.");
		}
	}
	@Override
	public Optional<String> getRoleByUserId(Long loginUserId) {
		// Fetch the role ID

        return usersRepository.findRoleNameByUserId(loginUserId)
				.orElseThrow(() -> new RoleNotFoundException("Role not found for user ID: " + loginUserId))
				.describeConstable();
		// Use flatMap to handle nested Optionals
//		return roleId.flatMap(id -> rolesRepository.findRoleById(id))
//				.orElseThrow(() -> new RoleNotFoundException("Role not found for user ID: " + loginUserId))
//				.describeConstable();
	}
}
