package com.mountmeru.entitymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.entity.Clusters;
import com.mountmeru.entitymanagement.entity.Stations;

@Repository
public interface ClustersRepository extends JpaRepository<Clusters, Long>{
	@Query ("select c from Clusters c where c.Id = :Id")
	Clusters findClusterByClusterId(@Param("Id") long Id);
	
	@Query ("select s from Stations s where s.ClusterID = :Id")
	List<Stations> findAllStationUnderCluster(@Param("Id") long Id);
	
	@Query ("select c from Clusters c where c.Manager_Id = :Manager_Id")
	List<Clusters> findAllClustersUnderManagerId(@Param("Manager_Id") long managerId);
}
