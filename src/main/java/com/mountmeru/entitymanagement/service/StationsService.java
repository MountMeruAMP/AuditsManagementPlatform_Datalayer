package com.mountmeru.entitymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.StationsDTO;

@Service
public interface StationsService {
	StationsDTO createStation(StationsDTO stationsDTO, long loginUserId);
	StationsDTO updateStation(StationsDTO stationsDTO, long loginUserId);
	String deleteStation(String stationId);
	StationsDTO getStationsById(String stationCode);
	List<StationsDTO> getAllStationsUnderCluster(long clusterId);
	List<StationsDTO> getAllStations();
	List<StationsDTO> getAllStationsUnderStationManager(long managerId);
}
