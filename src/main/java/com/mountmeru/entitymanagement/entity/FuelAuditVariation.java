package com.mountmeru.entitymanagement.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Fuel_Audit_Variation")
public class FuelAuditVariation {

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

    @Column(name = "Product_Type", length = 20)
    private String ProductType;

    @Column(name = "Gross_Stock_Variation", precision = 10, scale = 2)
    private BigDecimal GrossStockVariation;

    @Column(name = "Sum_recoverable", precision = 10, scale = 2)
    private BigDecimal SumRecoverable;

    @Column(name = "Permitted_Variation", precision = 10, scale = 2)
    private BigDecimal PermittedVariation;

    @Column(name = "Net_Variation", precision = 10, scale = 2)
    private BigDecimal NetVariation;

    @Column(name = "Stock_Variation_Percentage", precision = 10, scale = 2)
    private BigDecimal StockVariationPercentage;


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

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }

    public BigDecimal getGrossStockVariation() {
        return GrossStockVariation;
    }

    public void setGrossStockVariation(BigDecimal grossStockVariation) {
        GrossStockVariation = grossStockVariation;
    }

    public BigDecimal getSumRecoverable() {
        return SumRecoverable;
    }

    public void setSumRecoverable(BigDecimal sumRecoverable) {
        SumRecoverable = sumRecoverable;
    }

    public BigDecimal getPermittedVariation() {
        return PermittedVariation;
    }

    public void setPermittedVariation(BigDecimal permittedVariation) {
        PermittedVariation = permittedVariation;
    }

    public BigDecimal getNetVariation() {
        return NetVariation;
    }

    public void setNetVariation(BigDecimal netVariation) {
        NetVariation = netVariation;
    }

    public BigDecimal getStockVariationPercentage() {
        return StockVariationPercentage;
    }

    public void setStockVariationPercentage(BigDecimal stockVariationPercentage) {
        StockVariationPercentage = stockVariationPercentage;
    }

    @Override
    public String toString() {
        return "FuelAuditVariation{" +
                "Counter=" + Counter +
                ", CreatedTS=" + CreatedTS +
                ", UpdatedTS=" + UpdatedTS +
                ", CreatedBy=" + CreatedBy +
                ", UpdatedBy=" + UpdatedBy +
                ", Id=" + Id +
                ", AuditId=" + AuditId +
                ", ProductType='" + ProductType + '\'' +
                ", GrossStockVariation=" + GrossStockVariation +
                ", SumRecoverable=" + SumRecoverable +
                ", PermittedVariation=" + PermittedVariation +
                ", NetVariation=" + NetVariation +
                ", StockVariationPercentage=" + StockVariationPercentage +
                '}';
    }
}
