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


@Data
@Entity
@Table( name = "Region")
public class Regions{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;
	
	@Column(name = "createdTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
	private Date createdTS;
	
	@Column(name = "updatedTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
	private Date updatedTS;
	
	@Column(name = "createdBy")
	private String createdUser;
	
	@Column(name = "updatedBy")
	private String updatedUser;	
	
	@Column(name = "Id")
	private long Id;
	
	@Column(name = "Region_Name")
	private String Region_Name;
	
	@Column(name = "Region_Short_Name")
	private String Region_Short_Name;
	
	@Column(name = "Region_Country")
	private String Region_Country;
	
	@Column ( name="Status")
	private String Status;
	
	@Column ( name = "Manager_Id")
	private String Manager_Id;
	
	
	

	public long getCounter() {
		return Counter;
	}

	public void setCounter(long counter) {
		Counter = counter;
	}

	public Date getCreatedTS() {
		return createdTS;
	}

	public void setCreatedTS(Date createdTS) {
		this.createdTS = createdTS;
	}

	public Date getUpdatedTS() {
		return updatedTS;
	}

	public void setUpdatedTS(Date updatedTS) {
		this.updatedTS = updatedTS;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getRegion_Name() {
		return Region_Name;
	}

	public void setRegion_Name(String region_Name) {
		Region_Name = region_Name;
	}

	public String getRegion_Short_Name() {
		return Region_Short_Name;
	}

	public void setRegion_Short_Name(String region_Short_Name) {
		Region_Short_Name = region_Short_Name;
	}

	public String getRegion_Country() {
		return Region_Country;
	}

	public void setRegion_Country(String region_Country) {
		Region_Country = region_Country;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	public String getManager_Id() {
		return Manager_Id;
	}

	public void setManager_Id(String manager_Id) {
		Manager_Id = manager_Id;
	}
}
