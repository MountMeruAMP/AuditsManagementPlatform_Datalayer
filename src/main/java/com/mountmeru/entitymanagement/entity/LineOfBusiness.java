package com.mountmeru.entitymanagement.entity;

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
@Table( name = "LineOfBusiness")
public class LineOfBusiness {
	public long getCounter() {
		return Counter;
	}

	public void setCounter(long counter) {
		Counter = counter;
	}

	public String getLOBCode() {
		return LOBCode;
	}

	public void setLOBCode(String lOBCode) {
		LOBCode = lOBCode;
	}

	public String getLOB_Name() {
		return LOB_Name;
	}

	public void setLOB_Name(String lOB_Name) {
		LOB_Name = lOB_Name;
	}

	public String getLOB_ShortName() {
		return LOB_ShortName;
	}

	public void setLOB_ShortName(String lOB_ShortName) {
		LOB_ShortName = lOB_ShortName;
	}

	public long getManager_Id() {
		return Manager_Id;
	}

	public void setManager_Id(long manager_Id) {
		Manager_Id = manager_Id;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;
	
	@Column(name = "LOBCode")
	private String LOBCode;
	
	@Column(name = "LOB_Name")
	private String LOB_Name;
	
	@Column(name = "LOB_ShortName")
	private String LOB_ShortName;	

	@Column(name = "Manager_Id")
	private long Manager_Id;
	
	@Column ( name="Status")
	private String Status;
}
