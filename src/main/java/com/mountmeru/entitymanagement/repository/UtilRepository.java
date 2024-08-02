
package com.mountmeru.entitymanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.entity.Util;
@Repository
public interface UtilRepository extends JpaRepository<Util, Long> {

	@Query ("select ut from Util ut where ut.Type = :Type order by ut.Counter")
	List<Util> findAllByType(@Param("Type") String Type);
	
	@Query ("select ut from Util ut where ut.Value = :Value order by ut.Counter")
	List<Util> findAllByValue(@Param("Value") String Value);
}
