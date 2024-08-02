package com.mountmeru.entitymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mountmeru.entitymanagement.jsonresponses.AuditScoreSummary;
import com.mountmeru.entitymanagement.jsonresponses.CommonResponse;
import com.mountmeru.entitymanagement.jsonresponses.DashboardResponse;
import com.mountmeru.entitymanagement.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService oDashboardService;
   

    @GetMapping("/audit/getclusteravgscore")
    public ResponseEntity<AuditScoreSummary> getClusterAvgScoreByDays(@RequestHeader long loginUserId,
                                                                      @RequestParam(required = false) Integer days){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(oDashboardService.getClusterAvgScore(loginUserId, days), headers, HttpStatus.OK);
    }

    @GetMapping("/audit/getperformingstations")
    public ResponseEntity<CommonResponse> getScoresOfStations(@RequestHeader long loginUserId,
                                                              @RequestParam() String sort,
                                                              @RequestParam(required = false) Integer days){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(oDashboardService.getStationPerformanceByAvgScore(loginUserId, days, sort), headers, HttpStatus.OK);
    }

    @PostMapping("/getdashboarddetails")
    public ResponseEntity<DashboardResponse> getAllDashboardData(@RequestHeader long loginUserId){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(oDashboardService.getDashboardData(loginUserId), headers, HttpStatus.OK);
    }
}