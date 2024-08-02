package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.CountriesDTO;
import com.mountmeru.entitymanagement.entity.Countries;

@Service
public class CountriesMapper {
	public static Countries mapToObject(CountriesDTO dto)
	{
		Countries obj = new Countries(
				dto.getCounter(), 
				dto.getCountrycode(),
				dto.getCountry_name(),
				dto.getCountry_shortname(),
				dto.getManager_id(),
				dto.getStatus()
				);
		return obj;
	}	
	
	public static CountriesDTO maptoDTO(Countries obj)
	{
		CountriesDTO dto = new CountriesDTO(
				obj.getCounter(), 
				obj.getCountryCode(),
				obj.getCountry_Name(),
				obj.getCountry_ShortName(),
				obj.getManager_Id(),
				obj.getStatus()				
				
				);		
		return dto;
	}
}
