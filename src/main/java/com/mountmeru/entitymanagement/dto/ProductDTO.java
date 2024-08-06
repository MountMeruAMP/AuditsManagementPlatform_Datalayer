package com.mountmeru.entitymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductDTO {

    private long counter;
    private Date createdts;
    private Date updatedts;
    private Long createdby;
    private long updatedby;
    private long id;
    private String category;
    private String productname;
    private String productshortcode;
    private String productUOM;
    private BigDecimal productprice;
    private BigDecimal densitymin;
    private BigDecimal densitymax;
    private BigDecimal ProductLossLimit;

    public ProductDTO() {
    }

    public ProductDTO(long counter, Date createdts, Date updatedts, Long createdby, long updatedby, long id, String category, String productname, String productshortcode, String productUOM, BigDecimal productprice, BigDecimal densitymin, BigDecimal densitymax, BigDecimal productLossLimit) {
        this.counter = counter;
        this.createdts = createdts;
        this.updatedts = updatedts;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.id = id;
        this.category = category;
        this.productname = productname;
        this.productshortcode = productshortcode;
        this.productUOM = productUOM;
        this.productprice = productprice;
        this.densitymin = densitymin;
        this.densitymax = densitymax;
        ProductLossLimit = productLossLimit;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductshortcode() {
        return productshortcode;
    }

    public void setProductshortcode(String productshortcode) {
        this.productshortcode = productshortcode;
    }

    public String getProductUOM() {
        return productUOM;
    }

    public void setProductUOM(String productUOM) {
        this.productUOM = productUOM;
    }

    public BigDecimal getProductprice() {
        return productprice;
    }

    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    public BigDecimal getDensitymin() {
        return densitymin;
    }

    public void setDensitymin(BigDecimal densitymin) {
        this.densitymin = densitymin;
    }

    public BigDecimal getDensitymax() {
        return densitymax;
    }

    public void setDensitymax(BigDecimal densitymax) {
        this.densitymax = densitymax;
    }

    public BigDecimal getProductLossLimit() {
        return ProductLossLimit;
    }

    public void setProductLossLimit(BigDecimal productLossLimit) {
        ProductLossLimit = productLossLimit;
    }
}
