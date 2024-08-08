package com.mountmeru.entitymanagement.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class StockHygieneChecklistDTO {

    private long counter;
    private Date createdts;
    private Date updatedts;
    private Long createdby;
    private long updatedby;
    private long id;
    private long auditid;
    private String producttype;
    private Integer question;
    private Integer response;
    private String remarks;

    public StockHygieneChecklistDTO() {
    }

    public StockHygieneChecklistDTO(long counter, Date createdts, Date updatedts, Long createdby, long updatedby, long id, long auditid, String producttype, Integer question, Integer response, String remarks) {
        this.counter = counter;
        this.createdts = createdts;
        this.updatedts = updatedts;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.id = id;
        this.auditid = auditid;
        this.producttype = producttype;
        this.question = question;
        this.response = response;
        this.remarks = remarks;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public Date getCreatedts() {
        return createdts;
    }

    public void setCreatedts(Date createdts) {
        this.createdts = createdts;
    }

    public Date getUpdatedts() {
        return updatedts;
    }

    public void setUpdatedts(Date updatedts) {
        this.updatedts = updatedts;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public long getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(long updatedby) {
        this.updatedby = updatedby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuditid() {
        return auditid;
    }

    public void setAuditid(long auditid) {
        this.auditid = auditid;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
