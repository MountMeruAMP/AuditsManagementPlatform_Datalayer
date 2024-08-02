package com.mountmeru.entitymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.RegionsDTO;
import com.mountmeru.entitymanagement.dto.StationsDTO;

@Service
public interface RegionsService {
	RegionsDTO createStation(RegionsDTO regionsDTO, String loginUserId);
	RegionsDTO updateStation(RegionsDTO regionsDTO, String loginUserId);
	String deleteCluster(long stationId);
	RegionsDTO getClusterById(long clusterId);
	List<StationsDTO> getAllRegionsUnderCountry(long countryId);
	List<StationsDTO> getAllRegions();
}
