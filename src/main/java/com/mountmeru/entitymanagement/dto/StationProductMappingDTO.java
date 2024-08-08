package com.mountmeru.entitymanagement.dto;

import java.util.Date;

public class StationProductMappingDTO {

    private long counter;
    private Date createdts;
    private Date updatedts;
    private Long createdby;
    private long updatedby;
    private long id;
    private Long stationproductmappingid;
    private Long stationid;
    private Long productid;

    public StationProductMappingDTO() {
    }

    public StationProductMappingDTO(long counter, Date createdts, Date updatedts, Long createdby, long updatedby, long id, Long stationproductmappingid, Long stationid, Long productid) {
        this.counter = counter;
        this.createdts = createdts;
        this.updatedts = updatedts;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.id = id;
        this.stationproductmappingid = stationproductmappingid;
        this.stationid = stationid;
        this.productid = productid;
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

    public Long getStationproductmappingid() {
        return stationproductmappingid;
    }

    public void setStationproductmappingid(Long stationproductmappingid) {
        this.stationproductmappingid = stationproductmappingid;
    }

    public Long getStationid() {
        return stationid;
    }

    public void setStationid(Long stationid) {
        this.stationid = stationid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }
}
