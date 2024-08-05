package com.mountmeru.entitymanagement.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Station_Product_Mapping")
public class StationProductMapping {

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

    @Column(name = "Station_Product_Mapping_Id", unique = true)
    private long StationProductMappingId;

    @Column(name = "Station_ID", unique = true, nullable= false)
    private long StationID;

    @Column(name = "Product_Id", unique = true, nullable= false)
    private long ProductId;
}
