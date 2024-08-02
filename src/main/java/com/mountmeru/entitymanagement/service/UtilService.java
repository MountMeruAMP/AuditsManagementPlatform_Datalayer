package com.mountmeru.entitymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.UtilDTO;

@Service
public interface UtilService {
	List<UtilDTO> getAllRowsByType(String strType);
	List<UtilDTO> getAllRowsByValue(String strValue);
}
