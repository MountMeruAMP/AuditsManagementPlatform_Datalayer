package com.mountmeru.entitymanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.UtilDTO;
import com.mountmeru.entitymanagement.entity.Util;
import com.mountmeru.entitymanagement.mapper.UtilMapper;
import com.mountmeru.entitymanagement.repository.UtilRepository;
import com.mountmeru.entitymanagement.service.UtilService;

@Service
public class UtilServiceImpl  implements UtilService{
	@Autowired
	UtilRepository oUtilRepository;
	
	@Override
	public List<UtilDTO> getAllRowsByType(String strType) {
		// TODO Auto-generated method stub
		List<UtilDTO> listUtilDTO = new ArrayList<UtilDTO>();
		List<Util> aUtils = oUtilRepository.findAllByType(strType);
		for(Util oUtil: aUtils)
			listUtilDTO.add(UtilMapper.maptoDTO(oUtil));
		return listUtilDTO;
	}

	@Override
	public List<UtilDTO> getAllRowsByValue(String strValue) {
		// TODO Auto-generated method stub
		List<UtilDTO> listUtilDTO = new ArrayList<UtilDTO>();
		List<Util> aUtils = oUtilRepository.findAllByValue(strValue);
		for(Util oUtil: aUtils)
			listUtilDTO.add(UtilMapper.maptoDTO(oUtil));
		return listUtilDTO;
	}
}
