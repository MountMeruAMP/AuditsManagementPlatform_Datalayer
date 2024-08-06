package com.mountmeru.entitymanagement.dto;

import java.math.BigDecimal;
import java.util.Date;

public class FuelAuditVariationDTO {

    private long counter;
    private Date createdts;
    private Date updatedts;
    private Long createdby;
    private long updatedby;
    private long id;
    private long auditid;
    private String producttype;
    private BigDecimal grossstockvariation;
    private BigDecimal sumrecoverable;
    private BigDecimal permittedvariation;
    private BigDecimal netvariation;
    private BigDecimal stockvariationpercentage;

    public FuelAuditVariationDTO() {
    }

    public FuelAuditVariationDTO(long counter, Date createdts, Date updatedts, Long createdby, long updatedby, long id, long auditid, String producttype, BigDecimal grossstockvariation, BigDecimal sumrecoverable, BigDecimal permittedvariation, BigDecimal netvariation, BigDecimal stockvariationpercentage) {
        this.counter = counter;
        this.createdts = createdts;
        this.updatedts = updatedts;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.id = id;
        this.auditid = auditid;
        this.producttype = producttype;
        this.grossstockvariation = grossstockvariation;
        this.sumrecoverable = sumrecoverable;
        this.permittedvariation = permittedvariation;
        this.netvariation = netvariation;
        this.stockvariationpercentage = stockvariationpercentage;
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

    public BigDecimal getGrossstockvariation() {
        return grossstockvariation;
    }

    public void setGrossstockvariation(BigDecimal grossstockvariation) {
        this.grossstockvariation = grossstockvariation;
    }

    public BigDecimal getSumrecoverable() {
        return sumrecoverable;
    }

    public void setSumrecoverable(BigDecimal sumrecoverable) {
        this.sumrecoverable = sumrecoverable;
    }

    public BigDecimal getPermittedvariation() {
        return permittedvariation;
    }

    public void setPermittedvariation(BigDecimal permittedvariation) {
        this.permittedvariation = permittedvariation;
    }

    public BigDecimal getNetvariation() {
        return netvariation;
    }

    public void setNetvariation(BigDecimal netvariation) {
        this.netvariation = netvariation;
    }

    public BigDecimal getStockvariationpercentage() {
        return stockvariationpercentage;
    }

    public void setStockvariationpercentage(BigDecimal stockvariationpercentage) {
        this.stockvariationpercentage = stockvariationpercentage;
    }
}
