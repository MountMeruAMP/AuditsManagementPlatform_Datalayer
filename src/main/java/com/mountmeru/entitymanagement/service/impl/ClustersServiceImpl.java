package com.mountmeru.entitymanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.ClustersDTO;
import com.mountmeru.entitymanagement.dto.StationsDTO;
import com.mountmeru.entitymanagement.entity.Clusters;
import com.mountmeru.entitymanagement.entity.Stations;
import com.mountmeru.entitymanagement.mapper.ClusterMapper;
import com.mountmeru.entitymanagement.mapper.StationMapper;
import com.mountmeru.entitymanagement.repository.ClustersRepository;
import com.mountmeru.entitymanagement.service.ClustersService;
import com.mountmeru.entitymanagement.utils.DateUtils;
@Service
public class ClustersServiceImpl implements ClustersService{
	@Autowired
	ClustersRepository oClustersRepository;
	
	@Autowired
	DateUtils oDateUtils;  
	
	@Override
	public ClustersDTO createCluster(ClustersDTO clustersDTO, String loginUserId) {
		// TODO Auto-generated method stub

		Clusters clusters = ClusterMapper.mapToObject(clustersDTO);
		
		// Setting the mandatory fields.
		clusters.setCreatedTS(oDateUtils.getCurrentTimeStamp());
		clusters.setUpdatedTS(null);
		clusters.setCreatedBy(Long.valueOf(loginUserId));
		
		try {
			Clusters savedClusters = oClustersRepository.save(clusters);
			return ClusterMapper.maptoDTO(savedClusters);
		}
		catch(Exception e)
		{
			throw new RuntimeErrorException(new Error("Exception occurred while creating the Cluster."));
		}
	}

	@Override
	public ClustersDTO updateCluster(ClustersDTO clustersDTO, String loginUserId) {

		ClustersDTO clusterDTONew =  getClusterById(clustersDTO.getId());		
		Clusters cluster = ClusterMapper.mapToObject(clusterDTONew);
				
		// Setting the mandatory fields.		
		cluster.setUpdatedTS(oDateUtils.getCurrentTimeStamp());
		cluster.setUpdatedBy(Long.valueOf(loginUserId));

		// Saving the role.
		try {
			Clusters savedCluster = oClustersRepository.save(cluster);
			return ClusterMapper.maptoDTO(savedCluster);
		}
		catch(Exception e)
		{
			throw new RuntimeErrorException(new Error("Exception occurred while updating the Role."));
		}	
	}
	@Override
	public String deleteCluster(long clusterId) {
		// TODO Auto-generated method stub
		ClustersDTO clusterDTONew =  getClusterById(clusterId);
		Clusters cluster = ClusterMapper.mapToObject(clusterDTONew);	
		cluster.setStatus("Inactive");
		try {
			Clusters savedCluster = oClustersRepository.save(cluster);
			return "Station Inactivated";
		}
		catch(Exception e)
		{
			throw new RuntimeErrorException(new Error("Exception occurred while updating the Cluster Data."));
		}
	}

	@Override
	public ClustersDTO getClusterById(long clusterId) {
		// TODO Auto-generated method stub
		Clusters clusters = oClustersRepository.findClusterByClusterId(clusterId);
		if(null == clusters)
			return null;
		return ClusterMapper.maptoDTO(clusters);
	}

	@Override
	public List<ClustersDTO> getAllClustersUnderRegion(long regionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClustersDTO>  getAllClusters() {
		// TODO Auto-generated method stub		
		List<Clusters> listClusters = oClustersRepository.findAll();
		List<ClustersDTO> listClustersDTO = new ArrayList<ClustersDTO>();
		for(Clusters oClustors :listClusters)
		{
			listClustersDTO.add(ClusterMapper.maptoDTO(oClustors));
		}
		return listClustersDTO;
	}
	/**
	 * This method returns all the stations affiliated to the particular cluster
	 * @param clusterId
	 * @return
	 */
	public List<StationsDTO> getAllStationsAffiliatedToCluster(long clusterId)
	{
		List<Stations> listStations = oClustersRepository.findAllStationUnderCluster(clusterId);
		if(listStations.isEmpty())
		{
			return null;
		}
		List<StationsDTO> listStationsDTO = new ArrayList<StationsDTO>();
		for(Stations oStation : listStations)
			listStationsDTO.add(StationMapper.maptoDTO(oStation));
		return listStationsDTO;
	}
	public List<ClustersDTO> getAllClustorsForManagerid(long managerId)
	{
		List<ClustersDTO> listClustorsDTO = new ArrayList<ClustersDTO>();
		List<Clusters> listClusters = oClustersRepository.findAllClustersUnderManagerId(managerId);
		if(listClusters.isEmpty())
			return null;
		for(Clusters oClusters: listClusters)
			listClustorsDTO.add(ClusterMapper.maptoDTO(oClusters));
		return listClustorsDTO;  
	}
	@Override
	public List<StationsDTO> getAllStationsForClusterManagerid(long managerId)
	{
		List<Stations> listStations = new ArrayList<Stations>();		
		List<Clusters> listClusters = oClustersRepository.findAllClustersUnderManagerId(managerId);
		if(listClusters.isEmpty())
			return null;
		for(Clusters oClusters: listClusters)
		{
			listStations = oClustersRepository.findAllStationUnderCluster(oClusters.getId());
		}
		if(listStations.isEmpty())
			return null;
		List<StationsDTO> listStationsDTO = new ArrayList<StationsDTO>();
		for(Stations oStations: listStations)
			listStationsDTO.add(StationMapper.maptoDTO(oStations));			
		return listStationsDTO;
	}
}
