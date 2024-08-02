package com.mountmeru.entitymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mountmeru.entitymanagement.entity.UserLogin;



public interface UserLoginRepository extends CrudRepository<UserLogin, Long> {
	@Query ("select u from UserLogin u where u.Id = :userId order by u.createdTs desc")
	List<UserLogin> findByUserIdOTP(@Param("userId") String userId); 
}
