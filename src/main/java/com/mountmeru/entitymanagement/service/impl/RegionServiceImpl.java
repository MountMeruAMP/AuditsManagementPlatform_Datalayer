package com.mountmeru.entitymanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.RegionsDTO;
import com.mountmeru.entitymanagement.dto.StationsDTO;
import com.mountmeru.entitymanagement.service.RegionsService;
@Service
public class RegionServiceImpl implements RegionsService {

	@Override
	public RegionsDTO createStation(RegionsDTO regionsDTO, String loginUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegionsDTO updateStation(RegionsDTO regionsDTO, String loginUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCluster(long stationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegionsDTO getClusterById(long clusterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StationsDTO> getAllRegionsUnderCountry(long countryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StationsDTO> getAllRegions() {
		// TODO Auto-generated method stub
		return null;
	}

}
