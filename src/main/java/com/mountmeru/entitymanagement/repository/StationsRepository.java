package com.mountmeru.entitymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.entity.Stations;

@Repository
public interface StationsRepository extends JpaRepository<Stations, Long>{
	@Query ("select s from Stations s where s.Id = :Id")
	Stations findStationByStationId(@Param("Id") String Id); 
	
	@Query ("select s from Stations s where s.Manager_Id = :Manager_Id")
	List<Stations> findStationByManagerId(@Param("Manager_Id") String Manager_Id); 
	
	@Query ("select s from Stations s where s.StationCode = :StationCode")
	Stations findStationByStationCode(@Param("StationCode") String StationCode); 
}
