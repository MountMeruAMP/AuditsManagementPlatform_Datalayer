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
@Table( name = "Roles")
public class Roles{
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
	
	@Column(name = "RoleName")
	private String RoleName;
	
	@Column(name = "RoleShortName")
	private String RoleShortName;
	
	@Column ( name="Status")
	private String Status;	
	
	@Column ( name="Remark")
	private String Remark;

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

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public String getRoleShortName() {
		return RoleShortName;
	}

	public void setRoleShortName(String roleShortName) {
		RoleShortName = roleShortName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}	
}
