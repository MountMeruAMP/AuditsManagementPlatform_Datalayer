package com.mountmeru.entitymanagement.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Fuel_Audit_Staging")
public class FuelAuditStaging {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long Counter;

    @Column(name = "CreatedTS", columnDefinition = "Timestamp", nullable= false, insertable = true, updatable = true)
    private Date CreatedTS;

    @Column(name = "UpdatedTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
    private Date UpdatedTS;

    @Column(name = "CreatedBy", nullable= false)
    private long CreatedBy;

    @Column(name = "UpdatedBy")
    private long UpdatedBy;

    @Column(name = "Id", unique = true, nullable= false)
    private long Id;

    @Column(name = "Audit_Id", unique = true, nullable= false)
    private long AuditId;

    @Column(name = "Station_Product_Id", unique = true)
    private long StationProductId;

    @Column(name = "OpeningStock", precision = 10, scale = 2)
    private BigDecimal OpeningStock;

    @Column(name = "Receipts", precision = 10, scale = 2)
    private BigDecimal Receipts;

    @Column(name = "CustomerReturn", precision = 10, scale = 2)
    private BigDecimal CustomerReturn;

    @Column(name = "GrossSales", precision = 10, scale = 2)
    private BigDecimal GrossSales;

    @Column(name = "NetSales", precision = 10, scale = 2)
    private BigDecimal NetSales;

    @Column(name = "StockTransfer", precision = 10, scale = 2)
    private BigDecimal StockTransfer;

    @Column(name = "ClosingStockActual", precision = 10, scale = 2)
    private BigDecimal ClosingStockActual;

    @Column(name = "ClosingStockCalculated", precision = 10, scale = 2)
    private BigDecimal ClosingStockCalculated;

    @Column(name = "Variance", precision = 10, scale = 2)
    private BigDecimal Variance;

    @Column(name = "PumpTest", precision = 10, scale = 2)
    private BigDecimal PumpTest;

    @Column(name = "Observed_Density_Normal", precision = 10, scale = 2)
    private BigDecimal ObservedDensityNormal;

    @Column(name = "Observed_Temperature", precision = 10, scale = 2)
    private BigDecimal ObservedTemperature;

    @Column(name = "Observed_Density", precision = 10, scale = 2)
    private BigDecimal ObservedDensity;

    @Column(name = "Reference_Density", precision = 10, scale = 2)
    private BigDecimal ReferenceDensity;

    @Column(name = "Variation", precision = 10, scale = 2)
    private BigDecimal Variation;

    @Column(name = "Nozzle_Test_Result", precision = 10, scale = 2)
    private BigDecimal NozzleTestResult;

    @Column(name = "Nozzle_Test_Qty", precision = 10, scale = 2)
    private BigDecimal NozzleTestQty;

    @Column(name = "Nozzle_Test_Remarks", precision = 10, scale = 2)
    private BigDecimal NozzleTestRemarks;


    public long getCounter() {
        return Counter;
    }

    public void setCounter(long counter) {
        Counter = counter;
    }

    public Date getCreatedTS() {
        return CreatedTS;
    }

    public void setCreatedTS(Date createdTS) {
        CreatedTS = createdTS;
    }

    public Date getUpdatedTS() {
        return UpdatedTS;
    }

    public void setUpdatedTS(Date updatedTS) {
        UpdatedTS = updatedTS;
    }

    public long getCreatedBy() {
        return CreatedBy;
    }

    public void setCreatedBy(long createdBy) {
        CreatedBy = createdBy;
    }

    public long getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        UpdatedBy = updatedBy;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getAuditId() {
        return AuditId;
    }

    public void setAuditId(long auditId) {
        AuditId = auditId;
    }

    public long getStationProductId() {
        return StationProductId;
    }

    public void setStationProductId(long stationProductId) {
        StationProductId = stationProductId;
    }

    public BigDecimal getOpeningStock() {
        return OpeningStock;
    }

    public void setOpeningStock(BigDecimal openingStock) {
        OpeningStock = openingStock;
    }

    public BigDecimal getReceipts() {
        return Receipts;
    }

    public void setReceipts(BigDecimal receipts) {
        Receipts = receipts;
    }

    public BigDecimal getCustomerReturn() {
        return CustomerReturn;
    }

    public void setCustomerReturn(BigDecimal customerReturn) {
        CustomerReturn = customerReturn;
    }

    public BigDecimal getGrossSales() {
        return GrossSales;
    }

    public void setGrossSales(BigDecimal grossSales) {
        GrossSales = grossSales;
    }

    public BigDecimal getNetSales() {
        return NetSales;
    }

    public void setNetSales(BigDecimal netSales) {
        NetSales = netSales;
    }

    public BigDecimal getStockTransfer() {
        return StockTransfer;
    }

    public void setStockTransfer(BigDecimal stockTransfer) {
        StockTransfer = stockTransfer;
    }

    public BigDecimal getClosingStockActual() {
        return ClosingStockActual;
    }

    public void setClosingStockActual(BigDecimal closingStockActual) {
        ClosingStockActual = closingStockActual;
    }

    public BigDecimal getClosingStockCalculated() {
        return ClosingStockCalculated;
    }

    public void setClosingStockCalculated(BigDecimal closingStockCalculated) {
        ClosingStockCalculated = closingStockCalculated;
    }

    public BigDecimal getVariance() {
        return Variance;
    }

    public void setVariance(BigDecimal variance) {
        Variance = variance;
    }

    public BigDecimal getPumpTest() {
        return PumpTest;
    }

    public void setPumpTest(BigDecimal pumpTest) {
        PumpTest = pumpTest;
    }

    public BigDecimal getObservedDensityNormal() {
        return ObservedDensityNormal;
    }

    public void setObservedDensityNormal(BigDecimal observedDensityNormal) {
        ObservedDensityNormal = observedDensityNormal;
    }

    public BigDecimal getObservedTemperature() {
        return ObservedTemperature;
    }

    public void setObservedTemperature(BigDecimal observedTemperature) {
        ObservedTemperature = observedTemperature;
    }

    public BigDecimal getObservedDensity() {
        return ObservedDensity;
    }

    public void setObservedDensity(BigDecimal observedDensity) {
        ObservedDensity = observedDensity;
    }

    public BigDecimal getReferenceDensity() {
        return ReferenceDensity;
    }

    public void setReferenceDensity(BigDecimal referenceDensity) {
        ReferenceDensity = referenceDensity;
    }

    public BigDecimal getVariation() {
        return Variation;
    }

    public void setVariation(BigDecimal variation) {
        Variation = variation;
    }

    public BigDecimal getNozzleTestResult() {
        return NozzleTestResult;
    }

    public void setNozzleTestResult(BigDecimal nozzleTestResult) {
        NozzleTestResult = nozzleTestResult;
    }

    public BigDecimal getNozzleTestQty() {
        return NozzleTestQty;
    }

    public void setNozzleTestQty(BigDecimal nozzleTestQty) {
        NozzleTestQty = nozzleTestQty;
    }

    public BigDecimal getNozzleTestRemarks() {
        return NozzleTestRemarks;
    }

    public void setNozzleTestRemarks(BigDecimal nozzleTestRemarks) {
        NozzleTestRemarks = nozzleTestRemarks;
    }

    @Override
    public String toString() {
        return "FuelAuditStaging{" +
                "Counter=" + Counter +
                ", CreatedTS=" + CreatedTS +
                ", UpdatedTS=" + UpdatedTS +
                ", CreatedBy=" + CreatedBy +
                ", UpdatedBy=" + UpdatedBy +
                ", Id=" + Id +
                ", AuditId=" + AuditId +
                ", StationProductId=" + StationProductId +
                ", OpeningStock=" + OpeningStock +
                ", Receipts=" + Receipts +
                ", CustomerReturn=" + CustomerReturn +
                ", GrossSales=" + GrossSales +
                ", NetSales=" + NetSales +
                ", StockTransfer=" + StockTransfer +
                ", ClosingStockActual=" + ClosingStockActual +
                ", ClosingStockCalculated=" + ClosingStockCalculated +
                ", Variance=" + Variance +
                ", PumpTest=" + PumpTest +
                ", ObservedDensityNormal=" + ObservedDensityNormal +
                ", ObservedTemperature=" + ObservedTemperature +
                ", ObservedDensity=" + ObservedDensity +
                ", ReferenceDensity=" + ReferenceDensity +
                ", Variation=" + Variation +
                ", NozzleTestResult=" + NozzleTestResult +
                ", NozzleTestQty=" + NozzleTestQty +
                ", NozzleTestRemarks=" + NozzleTestRemarks +
                '}';
    }
}
