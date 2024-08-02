package com.mountmeru.entitymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.entity.ERB_Audit_Mapping;

@Repository
public interface ERB_Audit_MappingRepository extends JpaRepository<ERB_Audit_Mapping, Long>{
	@Query ("select am from ERB_Audit_Mapping am where am.Audit_Type = :Audit_Type order by am.Counter")
	List<ERB_Audit_Mapping> findAllTestForAudit(@Param("Audit_Type") String Audit_Type);
	
	
	@Query ("select st from ERB_Audit_Mapping st where st.Audit_Type = :Audit_Type and st.Header = :Header and st.Sub_Header = :Sub_Header and st.Additional_Notes = :Additional_Notes and st.Question = :Question order by Header, Sub_Header, Additional_Notes, Question ")
	List<ERB_Audit_Mapping> findAllByHeaderSubHeaderAddNotesQuestion(@Param("Audit_Type") String Audit_Type, @Param("Header") int Header,  @Param("Sub_Header") int Sub_Header,  @Param("Sub_Header") int Additional_Notes,  @Param("Question") int Question);
	
	@Query ("select st from ERB_Audit_Mapping st where st.Audit_Type = :Audit_Type and st.Header = :Header and st.Sub_Header = :Sub_Header and st.Additional_Notes = :Additional_Notes and st.Question <> :Question order by Header, Sub_Header, Additional_Notes, Question ")
	List<ERB_Audit_Mapping> findAllByHeaderSubHeaderAddNotesNotQuestion(@Param("Audit_Type") String Audit_Type, @Param("Header") int Header,  @Param("Sub_Header") int Sub_Header,  @Param("Sub_Header") int Additional_Notes,  @Param("Question") int Question);
	
	
	@Query ("select st from ERB_Audit_Mapping st where st.Audit_Type = :Audit_Type and st.Header = :Header and st.Sub_Header <> :Sub_Header and st.Additional_Notes = :Additional_Notes and st.Question <> :Question order by Header, Sub_Header, Additional_Notes, Question ")
	List<ERB_Audit_Mapping> findAllByHeaderNotSubHeaderNotQuestion(@Param("Audit_Type") String Audit_Type, @Param("Header") int Header,  @Param("Sub_Header") int Sub_Header,  @Param("Sub_Header") int Additional_Notes,  @Param("Question") int Question);
	
	// ERBCONA 
	// ERBTECH
	
}
