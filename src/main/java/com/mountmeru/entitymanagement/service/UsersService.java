package com.mountmeru.entitymanagement.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.UsersDTO;

@Service
public interface UsersService {
	UsersDTO  createUser(UsersDTO usersDTO, long loginUserId);
	UsersDTO getUsersByCounter(long id);
	UsersDTO getUsersByUserId(long userId);
	UsersDTO updateUser(UsersDTO usersDTO, long loginUserId);
	Optional<String> getRoleByUserId(Long loginUserId);
}
