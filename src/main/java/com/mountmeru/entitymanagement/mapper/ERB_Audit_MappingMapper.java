package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.ERB_Audit_MappingDTO;
import com.mountmeru.entitymanagement.entity.ERB_Audit_Mapping;
@Service
public class ERB_Audit_MappingMapper {
	public static ERB_Audit_Mapping mapToObject(ERB_Audit_MappingDTO dto)
	{
		ERB_Audit_Mapping obj = new ERB_Audit_Mapping(
				dto.getCounter(),
				dto.getCreatedby(), 
				dto.getAudittype(),
				dto.getHeader(),
				dto.getSubheader(), 
				dto.getAdditionalnotes(), 
				dto.getQuestion(), 
				dto.getDescription(), 
				dto.getPoints()
				);
		return obj; 
	}	
	public static ERB_Audit_MappingDTO maptoRolesDTO(ERB_Audit_Mapping obj)
	{
		ERB_Audit_MappingDTO dto = new ERB_Audit_MappingDTO( 
				obj.getCounter(),
				obj.getCreatedBy(), 
				obj.getAudit_Type(),
				obj.getHeader(),
				obj.getSub_Header(), 
				obj.getAdditional_Notes(), 
				obj.getQuestion(), 
				obj.getDescription(),
				obj.getPoints()
				);		 
		return dto;
	}
}
