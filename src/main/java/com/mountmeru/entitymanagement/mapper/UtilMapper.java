package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.UtilDTO;
import com.mountmeru.entitymanagement.entity.Util;

@Service
public class UtilMapper {
	public static Util mapToObject(UtilDTO dto)
	{
		Util obj = new Util(
				dto.getCounter(),
				dto.getCreatedby(),
				dto.getType(),
				dto.getValue(),
				dto.getPlaceholder_1(),
				dto.getPlaceholder_2(),
				dto.getPlaceholder_3()
				);
		return obj;
	}	
	public static UtilDTO maptoDTO(Util obj)
	{
		UtilDTO dto = new UtilDTO(
				obj.getCounter(),
				obj.getCreatedBy(),
				obj.getType(),
				obj.getValue(),
				obj.getPlaceholder_1(),
				obj.getPlaceholder_2(),
				obj.getPlaceholder_3()
				);
		return dto;
	}
}
