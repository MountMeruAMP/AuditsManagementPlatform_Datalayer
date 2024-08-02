package com.mountmeru.entitymanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mountmeru.entitymanagement.dto.projection.AuditScoreProjection;
import com.mountmeru.entitymanagement.entity.ScoreCard;

@Repository
public interface ScoreCardRepository extends JpaRepository<ScoreCard, Long> {

    @Query("SELECT s FROM ScoreCard s WHERE s.Audit_Id IN :auditIds ")
    List<ScoreCard> findByAudit_Id(List<Long> auditIds);


    @Query(value = "SELECT am.id, am.station_code, sc.max_score, sc.obtained_score  " +
            "FROM audit_master am " +
            "INNER JOIN score_card sc ON am.id = sc.audit_id " +
            "WHERE am.auditor = :Auditor AND am.state = :State AND am.station_code IN :StationCodes and am.start_time >= :startDate",
            nativeQuery = true
    )
    List<AuditScoreProjection> findScoresByStations(@Param("State") String State, @Param("Auditor") long Auditor,
                                                    @Param("StationCodes") List<String> StationCodes,
                                                    @Param("startDate") Date startDate);
}