package com.mountmeru.entitymanagement.dto;

import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.Date;

public class FuelAuditStagingDTO {

    private long counter;
    private Date createdts;
    private Date updatedts;
    private Long createdby;
    private long updatedby;
    private long id;
    private long auditid;
    private long stationproductid;
    private BigDecimal openingstock;
    private BigDecimal receipts;
    private BigDecimal customerreturn;
    private BigDecimal grosssales;
    private BigDecimal netsales;
    private BigDecimal stocktransfer;
    private BigDecimal closingstockactual;
    private BigDecimal closingstockcalculated;
    private BigDecimal variance;
    private BigDecimal pumptest;
    private BigDecimal observeddensitynormal;
    private BigDecimal observedtemperature;
    private BigDecimal observeddensity;
    private BigDecimal referencedensity;
    private BigDecimal variation;
    private BigDecimal nozzletestresult;
    private BigDecimal nozzletestqty;
    private BigDecimal nozzletestremarks;

    public FuelAuditStagingDTO() {
    }

    public FuelAuditStagingDTO(long counter, Date createdts, Date updatedts, Long createdby, long updatedby, long id, long auditid, long stationproductid, BigDecimal openingstock, BigDecimal receipts, BigDecimal customerreturn, BigDecimal grosssales, BigDecimal netsales, BigDecimal stocktransfer, BigDecimal closingstockactual, BigDecimal closingstockcalculated, BigDecimal variance, BigDecimal pumptest, BigDecimal observeddensitynormal, BigDecimal observedtemperature, BigDecimal observeddensity, BigDecimal referencedensity, BigDecimal variation, BigDecimal nozzletestresult, BigDecimal nozzletestqty, BigDecimal nozzletestremarks) {
        this.counter = counter;
        this.createdts = createdts;
        this.updatedts = updatedts;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.id = id;
        this.auditid = auditid;
        this.stationproductid = stationproductid;
        this.openingstock = openingstock;
        this.receipts = receipts;
        this.customerreturn = customerreturn;
        this.grosssales = grosssales;
        this.netsales = netsales;
        this.stocktransfer = stocktransfer;
        this.closingstockactual = closingstockactual;
        this.closingstockcalculated = closingstockcalculated;
        this.variance = variance;
        this.pumptest = pumptest;
        this.observeddensitynormal = observeddensitynormal;
        this.observedtemperature = observedtemperature;
        this.observeddensity = observeddensity;
        this.referencedensity = referencedensity;
        this.variation = variation;
        this.nozzletestresult = nozzletestresult;
        this.nozzletestqty = nozzletestqty;
        this.nozzletestremarks = nozzletestremarks;
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

    public long getStationproductid() {
        return stationproductid;
    }

    public void setStationproductid(long stationproductid) {
        this.stationproductid = stationproductid;
    }

    public BigDecimal getOpeningstock() {
        return openingstock;
    }

    public void setOpeningstock(BigDecimal openingstock) {
        this.openingstock = openingstock;
    }

    public BigDecimal getReceipts() {
        return receipts;
    }

    public void setReceipts(BigDecimal receipts) {
        this.receipts = receipts;
    }

    public BigDecimal getCustomerreturn() {
        return customerreturn;
    }

    public void setCustomerreturn(BigDecimal customerreturn) {
        this.customerreturn = customerreturn;
    }

    public BigDecimal getGrosssales() {
        return grosssales;
    }

    public void setGrosssales(BigDecimal grosssales) {
        this.grosssales = grosssales;
    }

    public BigDecimal getNetsales() {
        return netsales;
    }

    public void setNetsales(BigDecimal netsales) {
        this.netsales = netsales;
    }

    public BigDecimal getStocktransfer() {
        return stocktransfer;
    }

    public void setStocktransfer(BigDecimal stocktransfer) {
        this.stocktransfer = stocktransfer;
    }

    public BigDecimal getClosingstockactual() {
        return closingstockactual;
    }

    public void setClosingstockactual(BigDecimal closingstockactual) {
        this.closingstockactual = closingstockactual;
    }

    public BigDecimal getClosingstockcalculated() {
        return closingstockcalculated;
    }

    public void setClosingstockcalculated(BigDecimal closingstockcalculated) {
        this.closingstockcalculated = closingstockcalculated;
    }

    public BigDecimal getVariance() {
        return variance;
    }

    public void setVariance(BigDecimal variance) {
        this.variance = variance;
    }

    public BigDecimal getPumptest() {
        return pumptest;
    }

    public void setPumptest(BigDecimal pumptest) {
        this.pumptest = pumptest;
    }

    public BigDecimal getObserveddensitynormal() {
        return observeddensitynormal;
    }

    public void setObserveddensitynormal(BigDecimal observeddensitynormal) {
        this.observeddensitynormal = observeddensitynormal;
    }

    public BigDecimal getObservedtemperature() {
        return observedtemperature;
    }

    public void setObservedtemperature(BigDecimal observedtemperature) {
        this.observedtemperature = observedtemperature;
    }

    public BigDecimal getObserveddensity() {
        return observeddensity;
    }

    public void setObserveddensity(BigDecimal observeddensity) {
        this.observeddensity = observeddensity;
    }

    public BigDecimal getReferencedensity() {
        return referencedensity;
    }

    public void setReferencedensity(BigDecimal referencedensity) {
        this.referencedensity = referencedensity;
    }

    public BigDecimal getVariation() {
        return variation;
    }

    public void setVariation(BigDecimal variation) {
        this.variation = variation;
    }

    public BigDecimal getNozzletestresult() {
        return nozzletestresult;
    }

    public void setNozzletestresult(BigDecimal nozzletestresult) {
        this.nozzletestresult = nozzletestresult;
    }

    public BigDecimal getNozzletestqty() {
        return nozzletestqty;
    }

    public void setNozzletestqty(BigDecimal nozzletestqty) {
        this.nozzletestqty = nozzletestqty;
    }

    public BigDecimal getNozzletestremarks() {
        return nozzletestremarks;
    }

    public void setNozzletestremarks(BigDecimal nozzletestremarks) {
        this.nozzletestremarks = nozzletestremarks;
    }
}
