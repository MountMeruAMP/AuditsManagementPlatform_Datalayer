package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.StationsDTO;
import com.mountmeru.entitymanagement.entity.Stations;
@Service
public class StationMapper {

	public static Stations mapToObject(StationsDTO stationsDTO)
	{
		Stations stations = new Stations(
				stationsDTO.getCounter(),				
				stationsDTO.getCreatedts(),
				stationsDTO.getUpdatedts(),					
				stationsDTO.getCreatedby(),
				stationsDTO.getUpdatedby(),				
				stationsDTO.getStationcode(),
				stationsDTO.getStationname(),
				stationsDTO.getStationtype(),
				stationsDTO.getProvince(),
				stationsDTO.getEmail1(),
				stationsDTO.getEmail2(),
				stationsDTO.getPhone1(),
				stationsDTO.getPhone2(),	
				stationsDTO.getManager_id(),
				stationsDTO.getLati(),	
				stationsDTO.getLongi(),					
				stationsDTO.getGeofence(),
				stationsDTO.getClusterid(),
				stationsDTO.getStatus()
		);
		return stations;
	}
	public static StationsDTO maptoDTO(Stations stationsDTO)
	{
		StationsDTO station = new StationsDTO(
				stationsDTO.getCounter(),				
				stationsDTO.getCreatedTS(),
				stationsDTO.getUpdatedTS(),					
				stationsDTO.getCreatedBy(),
				stationsDTO.getUpdatedBy(),				
				stationsDTO.getStationCode(),
				stationsDTO.getStationName(),
				stationsDTO.getStationType(),
				stationsDTO.getProvince(),
				stationsDTO.getEMail1(),
				stationsDTO.getEMail2(),
				stationsDTO.getPhone1(),
				stationsDTO.getPhone2(),	
				stationsDTO.getManager_Id(),
				stationsDTO.getLATI(),	
				stationsDTO.getLONGI(),					
				stationsDTO.getGeofence(),
				stationsDTO.getClusterID(),
				stationsDTO.getStatus()
				);		
		return station;
	}
}
