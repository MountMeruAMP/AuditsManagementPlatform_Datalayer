package com.mountmeru.entitymanagement.validators;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.StationsDTO;
@Service
public class StationValidator extends CommonValidator{
	public void validateStation(StationsDTO station) throws RuntimeException
	{
		 validateEmail(station.getEmail1());
		 validateEmail(station.getEmail2());
		 validatePhone(station.getPhone1());
		 validatePhone(station.getPhone2());
		 validateProvince(station.getProvince());		 
	}	
}
