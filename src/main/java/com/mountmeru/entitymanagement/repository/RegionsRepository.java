package com.mountmeru.entitymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.entity.Regions;

@Repository
public interface RegionsRepository extends JpaRepository<Regions, Long>{

}
