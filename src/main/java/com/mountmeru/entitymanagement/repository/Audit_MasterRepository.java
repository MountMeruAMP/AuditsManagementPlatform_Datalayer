package com.mountmeru.entitymanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.entity.Audit_Master;

@Repository
public interface Audit_MasterRepository extends JpaRepository<Audit_Master, Long>{
	@Query ("select am from Audit_Master am where am.Id = :Id ") 
	Audit_Master getOneByAuditId(@Param("Id") long Id);
	
	@Query ("select am from Audit_Master am where am.State = :State order by am.StartTime desc")
	List<Audit_Master> findAllAuditsByState(@Param("State") String State);
	
	@Query ("select am from Audit_Master am where am.State = 'Scheduled' order by am.StartTime desc")
	List<Audit_Master>  findAllScheduledAudits();
	
	@Query ("select am from Audit_Master am where am.State = :State and am.Auditor = :Auditor order by am.CreatedTS desc")
	List<Audit_Master>  findAllAuditsForAuditor(@Param("State") String State , @Param("Auditor") long Auditor);
	 
	@Query ("select am from Audit_Master am where am.State = :State and am.StationCode = :StationCode order by am.CreatedTS desc")
	List<Audit_Master>  findAllAuditsForStation(@Param("State") String State , @Param("StationCode") String StationCode);
	
	@Query ("select am from Audit_Master am where am.StationCode = :StationCode and am.Type = :Type order by am.CreatedTS desc limit 3")
	List<Audit_Master>  findAllAuditsForStationAndAuditType(@Param("StationCode") String StationCode, @Param("Type") String Type);
	
	
	@Query ("select am from Audit_Master am where am.State = :State and am.StationCode IN :StationCode and am.StartTime >= :startTime order by am.CreatedTS desc")
	List<Audit_Master>  findAllAuditsForStation(@Param("State") String State , @Param("StationCode") List<String> StationCode, @Param("startTime") Date startTime);

	@Query ("select am from Audit_Master am where am.State = :State and am.Auditor = :Auditor and am.StationCode IN :StationCode and am.StartTime >= :startTime " +
			"and am.StartTime <= :endTime order by am.CreatedTS desc") 
	List<Audit_Master>  findAllAuditsForStationByDate(@Param("State") String State, @Param("StationCode") List<String> StationCode, @Param("Auditor") long Auditor ,
													  @Param("startTime") Date startTime, @Param("endTime") Date endTime);

	@Query ("select am from Audit_Master am where am.Auditor = :Auditor and am.StationCode IN :StationCode and am.StartTime >= :startDate order by am.StartTime desc")
	List<Audit_Master>  findLastNCompletedAudits(@Param("Auditor") long Auditor, @Param("StationCode") List<String> StationCode, @Param("startDate") Date startDate);


	@Query ("select am from Audit_Master am where am.Auditor = :Auditor and am.StationCode IN :StationCode and am.StartTime >= :startDate order by am.StartTime desc")
	List<Audit_Master>  findLastNAudits(@Param("Auditor") long Auditor, @Param("StationCode") List<String> StationCode,
												 @Param("startDate") Date startDate);

	@Query ("select am from Audit_Master am where am.State = :State and am.Auditor = :Auditor and am.StationCode IN :StationCode and am.StartTime >= :startDate order by am.StartTime desc")
	List<Audit_Master>  findLastNCompletedAudits(@Param("State") String State, @Param("Auditor") long Auditor, @Param("StationCode") List<String> StationCode,
												 @Param("startDate") Date startDate);

}
