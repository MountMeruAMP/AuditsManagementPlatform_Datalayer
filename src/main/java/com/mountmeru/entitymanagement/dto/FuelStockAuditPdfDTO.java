package com.mountmeru.entitymanagement.dto;

import lombok.Data;

@Data
public class FuelStockAuditPdfDTO {

    private String stationName;
    private String stationType;
    private String stationCode;
    private String region;
    private String smName;
    private String cmName;
    private String rhName;
    private String auditorName;
    private String dateOfAudit;
    private String dateOfLastAudit;
    private String startTime;
    private String endTime;

    private String fileSource;
    private String fileDestination;
}
