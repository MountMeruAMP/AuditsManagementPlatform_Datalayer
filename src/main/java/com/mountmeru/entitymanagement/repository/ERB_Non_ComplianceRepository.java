package com.mountmeru.entitymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mountmeru.entitymanagement.entity.ERB_Non_Compliance;

public interface ERB_Non_ComplianceRepository extends JpaRepository<ERB_Non_Compliance, Long>{
	@Query ("select am from ERB_Non_Compliance am where am.Audit_Id = :Audit_Id ") 
	List<ERB_Non_Compliance> getAllNonComplainceForAuditId(@Param("Audit_Id") long Audit_Id);
	
	@Query ("select st from ERB_Non_Compliance st where st.Audit_Id = :Audit_Id and st.Header = :Header and st.Sub_Header = :Sub_Header and st.Additional_Notes = :Additional_Notes and st.Question = :Question ")
	ERB_Non_Compliance getOneByAuditIdHeaderSubHeaderAddNotesQuestion(@Param("Audit_Id") long  Audit_Id, @Param("Header") int Header, @Param("Sub_Header") int Sub_Header, @Param("Additional_Notes") int Additional_Notes, @Param("Question") int Question);
}
