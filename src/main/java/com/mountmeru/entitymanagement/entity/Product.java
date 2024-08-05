package com.mountmeru.entitymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long Counter;

    @Column(name = "CreatedTS", columnDefinition = "Timestamp", nullable= false, insertable = true, updatable = true)
    private Date CreatedTS;

    @Column(name = "UpdatedTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
    private Date UpdatedTS;

    @Column(name = "CreatedBy", nullable = false)
    private long CreatedBy;

    @Column(name = "UpdatedBy")
    private long UpdatedBy;

    @Column(name = "Id", unique = true, nullable= false)
    private long Id;

    @Column(name = "Category", length = 30)
    private String Category;

    @Column(name = "Product_Name", length = 100, unique = true)
    private String ProductName;

    @Column(name = "Product_Short_Code", length = 10, unique = true)
    private String ProductShortCode;

    @Column(name = "Product_UOM")
    private String ProductUOM;

//    @Column(name = "Product_Price", length = 100)
    @Column(name = "Product_Price", precision = 10, scale = 2)
    private BigDecimal ProductPrice;

    @Column(name = "Density_Min", precision = 10, scale = 2)
    private BigDecimal DensityMin;

    @Column(name = "Density_Max", precision = 10, scale = 2)
    private BigDecimal DensityMax;

    @Column(name = "Product_Loss_Limit", precision = 5, scale = 2)
    private BigDecimal ProductLossLimit;




}
