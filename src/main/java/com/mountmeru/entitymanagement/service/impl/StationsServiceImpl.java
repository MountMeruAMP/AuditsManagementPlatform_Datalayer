package com.mountmeru.entitymanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.StationsDTO;
import com.mountmeru.entitymanagement.entity.Stations;
import com.mountmeru.entitymanagement.mapper.StationMapper;
import com.mountmeru.entitymanagement.repository.StationsRepository;
import com.mountmeru.entitymanagement.service.StationsService;
import com.mountmeru.entitymanagement.utils.DateUtils;
import com.mountmeru.entitymanagement.validators.StationValidator;
@Service
public class StationsServiceImpl implements StationsService{
	@Autowired
	DateUtils oDateUtils;
	
	@Autowired
	private StationsRepository stationsRepository;
	
	@Autowired
	private StationValidator oStationValidator;
	
	@Override
	public StationsDTO createStation(StationsDTO stationsDTO, long loginUserId) {
		// TODO Auto-generated method stub	
		oStationValidator.validateStation(stationsDTO);
		validateDuplicateStationId(stationsDTO.getStationcode());
		Stations stations = StationMapper.mapToObject(stationsDTO);
		
		// Setting the mandatory fields.
		stations.setCreatedTS(oDateUtils.getCurrentTimeStamp());
		stations.setUpdatedTS(null);
		stations.setCreatedBy(loginUserId);		
		try {
			Stations savedStations = stationsRepository.save(stations);
			return StationMapper.maptoDTO(savedStations);
		}
		catch(Exception e)
		{
			throw new RuntimeErrorException(new Error("Exception occurred while creating the Station."));
		}
	}

	@Override
	public StationsDTO updateStation(StationsDTO stationsDTO, long loginUserId) {
		// TODO Auto-generated method stub
		StationsDTO stationsDTONew =  getStationsById(stationsDTO.getStationcode());		
		Stations stations = StationMapper.mapToObject(stationsDTONew);				
		// Setting the mandatory fields.		
		stations.setUpdatedTS(oDateUtils.getCurrentTimeStamp());
		stations.setUpdatedBy(loginUserId);
		// Saving the role.
		try {
			Stations savedStation = stationsRepository.save(stations);
			return StationMapper.maptoDTO(savedStation);
		}
		catch(Exception e)
		{
			throw new RuntimeErrorException(new Error("Exception occurred while updating the Station Data."));
		}
	}

	@Override
	public String deleteStation(String stationId) { 
		// TODO Auto-generated method stub
		StationsDTO roleDTONew =  getStationsById(stationId);
		Stations stations = StationMapper.mapToObject(roleDTONew);	
		stations.setStatus("Inactive");
		try {
			Stations savedStation = stationsRepository.save(stations);
			return "Station Inactivated";
		}
		catch(Exception e)
		{
			throw new RuntimeErrorException(new Error("Exception occurred while updating the Station Data."));
		}
	}

	@Override
	public StationsDTO getStationsById(String stationCode) {
		// TODO Auto-generated method stub
		Stations station = stationsRepository.findStationByStationCode(stationCode); 
		if(null == station)
			return null;
		return StationMapper.maptoDTO(station);
		
	}

	@Override
	public List<StationsDTO> getAllStationsUnderCluster(long clusterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StationsDTO> getAllStations() {
		// TODO Auto-generated method stub
		List<Stations> listStation = stationsRepository.findAll();
		List<StationsDTO> listStationDTO = new ArrayList<StationsDTO>();
		for(Stations station: listStation)
		{
			listStationDTO.add(StationMapper.maptoDTO(station));
		}
		return listStationDTO;
	}
	@Override
	public List<StationsDTO> getAllStationsUnderStationManager(long managerUserId)
	{
		List<Stations> listStations = stationsRepository.findStationByManagerId(String.valueOf(managerUserId));
		if(listStations.isEmpty())
		{
			return null;
		}
		List<StationsDTO> listStationDTO = new ArrayList<StationsDTO>();
		for(Stations station: listStations)
		{
			listStationDTO.add(StationMapper.maptoDTO(station));
		}
		return listStationDTO;
	}
	private void validateDuplicateStationId(String stationId) throws RuntimeException
	{
		if(null != getStationsById(stationId))
		{
			new RuntimeErrorException(new Error("Station already exists with this Id."));
		}
		return;
	}
}
