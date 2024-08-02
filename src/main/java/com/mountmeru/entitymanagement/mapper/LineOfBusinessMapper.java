package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.LineOfBusinessDTO;
import com.mountmeru.entitymanagement.entity.LineOfBusiness;

@Service
public class LineOfBusinessMapper {

	public static LineOfBusiness mapToObject(LineOfBusinessDTO dto)
	{
		LineOfBusiness obj = new LineOfBusiness(
				dto.getCounter(), 
				dto.getLobcode(),
				dto.getLob_name(),
				dto.getLob_shortname(),
				dto.getManager_id(),
				dto.getStatus()
				);
		return obj;
	}	
	
	public static LineOfBusinessDTO maptoDTO(LineOfBusiness obj)
	{
		LineOfBusinessDTO dto = new LineOfBusinessDTO(
				obj.getCounter(), 
				obj.getLOBCode(),
				obj.getLOB_Name(),
				obj.getLOB_ShortName(),
				obj.getManager_Id(),
				obj.getStatus()				
				
				);		
		return dto;
	}
}
