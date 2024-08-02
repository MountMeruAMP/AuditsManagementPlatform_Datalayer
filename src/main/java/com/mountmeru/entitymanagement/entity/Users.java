package com.mountmeru.entitymanagement.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
@Entity
@Data
public class Users{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;	
	
	@Column(name = "CreatedTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
	private Date CreatedTS;	
	
	@Column(name = "UpdatedTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
	private Date UpdatedTS;
	
	@Column(name = "CreatedBy")
	private long CreatedBy;
	
	@Column(name = "UpdatedBy")
	private long UpdatedBy;	
	
	@Column(name = "Id")
	private long Id;
	
	@Column(name = "Role")
	private long Role;
	
	@Column( name = "FirstName")
	private String FirstName;
	
	@Column ( name = "MiddleName")
	private String MiddleName;	

	@Column (name = "LastName")
	private String LastName;
	
	@Column ( name = "EMail")
	private String EMail;
	
	@Column ( name = "Phone1")
	private String Phone1;
	
	@Column( name = "Phone2")
	private String Phone2;
	
	@Column ( name = "Designation")
	private String Designation;	
	
	@Column ( name = "Status")
	private String Status;

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

	public long getRole() {
		return Role;
	}

	public void setRole(long role) {
		Role = role;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEMail() {
		return EMail;
	}

	public void setEMail(String eMail) {
		EMail = eMail;
	}

	public String getPhone1() {
		return Phone1;
	}

	public void setPhone1(String phone1) {
		Phone1 = phone1;
	}

	public String getPhone2() {
		return Phone2;
	}

	public void setPhone2(String phone2) {
		Phone2 = phone2;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
