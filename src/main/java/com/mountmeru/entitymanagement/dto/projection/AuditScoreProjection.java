package com.mountmeru.entitymanagement.dto.projection;

public interface AuditScoreProjection {
    Long getId();
    String getStation_code();
    Integer getMax_score();
    Integer getObtained_score();
}