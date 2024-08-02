package com.mountmeru.entitymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.entity.ERB_Audit_Staging;

@Repository
public interface ERB_Audit_StagingRepository extends JpaRepository<ERB_Audit_Staging, Long>{
	@Query ("select st from ERB_Audit_Staging st where st.Audit_Id = :Audit_Id")
	List<ERB_Audit_Staging> findAllRecordsByAuditId(@Param("Audit_Id") long  Audit_Id);	
	
	@Query ("select st from ERB_Audit_Staging st where st.Audit_Id = :Audit_Id and st.Header = :Header and st.Sub_Header = :Sub_Header and st.Additional_Notes = :Additional_Notes and st.Question = :Question ")
	ERB_Audit_Staging getOneByAuditIdHeaderSubHeaderAddNotesQuestion(@Param("Audit_Id") long  Audit_Id, @Param("Header") int Header, @Param("Sub_Header") int Sub_Header, @Param("Additional_Notes") int Additional_Notes, @Param("Question") int Question);
	
}
