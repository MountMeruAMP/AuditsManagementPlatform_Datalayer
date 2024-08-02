package com.mountmeru.entitymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.entity.Roles;


@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

	@Query ("select r from Roles r where r.Id = :Id")
	Roles findRoleByRoleId(@Param("Id") long Id); 
}
