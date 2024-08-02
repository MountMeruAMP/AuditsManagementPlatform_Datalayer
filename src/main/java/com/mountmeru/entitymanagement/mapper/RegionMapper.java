package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.RegionsDTO;
import com.mountmeru.entitymanagement.entity.Regions;
@Service
public class RegionMapper {

	public static Regions mapToObject(RegionsDTO regionsDTO)
	{
		Regions regions = new Regions(
				regionsDTO.getCounter(), 
				regionsDTO.getCreatedTS(),
				regionsDTO.getUpdatedTS(),
				regionsDTO.getCreatedUser(),
				regionsDTO.getUpdatedUser(),
				regionsDTO.getId(),		
				regionsDTO.getRegion_Name(),
				regionsDTO.getRegion_Short_Name(),
				regionsDTO.getRegion_Country(),
				regionsDTO.getStatus(),	
				regionsDTO.getManager_Id() 
				);
		return regions;
	}	
	public static RegionsDTO maptoDTO(Regions regions)
	{
		RegionsDTO regionsDTO = new RegionsDTO(
				regions.getCounter(),				
				regions.getCreatedTS(),
				regions.getUpdatedTS(),
				regions.getCreatedUser(),
				regions.getUpdatedUser(),
				regions.getId(),				
				regions.getRegion_Name(),
				regions.getRegion_Short_Name(),
				regions.getRegion_Country(),
				regions.getStatus(),	
				regions.getManager_Id()
				);		
		return regionsDTO;
	}
}
