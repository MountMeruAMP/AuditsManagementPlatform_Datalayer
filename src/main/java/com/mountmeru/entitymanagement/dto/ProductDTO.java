package com.mountmeru.entitymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
