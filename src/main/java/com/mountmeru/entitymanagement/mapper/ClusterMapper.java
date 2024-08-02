package com.mountmeru.entitymanagement.mapper;

import org.springframework.stereotype.Service;

import com.mountmeru.entitymanagement.dto.ClustersDTO;
import com.mountmeru.entitymanagement.entity.Clusters;
@Service
public class ClusterMapper {
	public static Clusters mapToObject(ClustersDTO clustersDTO)
	{
		Clusters clusters = new Clusters(
				clustersDTO.getCounter(),				
				clustersDTO.getCreatedts(),
				clustersDTO.getUpdatedts(),
				clustersDTO.getCreatedby(),
				clustersDTO.getUpdatedby(),
				clustersDTO.getId(),			
				clustersDTO.getName(),
				clustersDTO.getShortname(),
				clustersDTO.getManagerid(),
				clustersDTO.getStatus(),	
				clustersDTO.getRegioncode() 
				);
		return clusters;
	}	
	public static ClustersDTO maptoDTO(Clusters clusters)
	{
		ClustersDTO clustersDTO = new ClustersDTO(
				clusters.getCounter(),
				
				clusters.getCreatedTS(),
				clusters.getUpdatedTS(),
				clusters.getCreatedBy(),
				clusters.getUpdatedBy(),
				clusters.getId(),				
				clusters.getName(),
				clusters.getShortName(),
				clusters.getManager_Id(),
				clusters.getStatus(),
				clusters.getRegionCode() 
				);		
		return clustersDTO;
	}
}
