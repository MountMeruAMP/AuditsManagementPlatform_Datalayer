package com.mountmeru.entitymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	@Query ("select u from Users u where u.Id = :userId")
	Users[] findByUserId(@Param("userId") long userId); 
	
	@Query ("select u from Users u where u.Role = :Role")
	Users[] findByRole(@Param("Role") long Role); 
	
	@Query("SELECT r.RoleShortName FROM Roles r, Users u WHERE u.Role = r.Id AND u.Id = :userId")
	Optional<String> findRoleNameByUserId(@Param("userId") Long userId);
	
}
