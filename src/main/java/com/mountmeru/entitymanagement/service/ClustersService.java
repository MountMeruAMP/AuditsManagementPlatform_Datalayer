package com.mountmeru.entitymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.ClustersDTO;
import com.mountmeru.entitymanagement.dto.StationsDTO;

@Service
public interface ClustersService {
	ClustersDTO createCluster(ClustersDTO clustersDTO, String loginUserId);
	ClustersDTO updateCluster(ClustersDTO clustersDTO, String loginUserId);
	String deleteCluster(long stationId);
	ClustersDTO getClusterById(long clusterId);
	List<ClustersDTO> getAllClustersUnderRegion(long regionId);
	List<ClustersDTO> getAllClusters();  
	List<StationsDTO> getAllStationsForClusterManagerid(long managerId);
}
