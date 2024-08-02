package com.mountmeru.entitymanagement.mapper;

import com.mountmeru.entitymanagement.dto.ScoreCardDTO;
import com.mountmeru.entitymanagement.entity.ScoreCard;

public class ScoreCardMapper {

	public static ScoreCard mapToObject(ScoreCardDTO dto)
	{
		ScoreCard obj = new ScoreCard(
				dto.getCounter(),
				dto.getAudit_id(),
				dto.getMax_score(),
				dto.getObtained_score(), 
				dto.getNumber_nc()
				);
		return obj;
	}	
	public static ScoreCardDTO maptoDTO(ScoreCard obj)
	{
		ScoreCardDTO dto = new ScoreCardDTO(
				obj.getCounter(),
				obj.getAudit_Id(),
				obj.getMax_Score(),
				obj.getObtained_Score(), 
				obj.getNumber_NC()
				);
		return dto;
	}

}
