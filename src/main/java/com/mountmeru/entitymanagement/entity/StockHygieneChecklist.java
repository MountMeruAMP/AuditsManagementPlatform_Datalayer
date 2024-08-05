package com.mountmeru.entitymanagement.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Stock_Hygiene_Checklist")
public class StockHygieneChecklist {

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

    @Column(name = "Product_Type", length = 20, unique = true)
    private String ProductType;

    @Column(name = "Question", unique = true)
    private Integer Question;

    @Column(name = "Response", unique = true)
    private Integer Response;

    @Column(name = "Remarks", length = 200, unique = true)
    private String Remarks;
}
