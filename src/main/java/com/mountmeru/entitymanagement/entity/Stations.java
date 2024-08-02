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
@Table(name = "Stations")
@Entity
@Data
public class Stations{
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;	

	@Column(name = "CreatedTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
	private Date CreatedTS;	
	
	@Column(name = "UpdatesTS", columnDefinition = "Timestamp", nullable= true, insertable = true, updatable = true)
	private Date updatedTS;
	
	@Column(name = "CreatedBy")
	private long CreatedBy;
	
	@Column(name = "UpdatedBy")
	private long UpdatedBy;
	
	@Column(name = "StationCode")
	private String StationCode;
	
	@Column(name = "StationName")
	private String StationName;
	
	@Column ( name = "StationType")
	private String StationType;
	
	@Column ( name = "Province")
	private String Province;
	
	@Column ( name = "EMail1")
	private String EMail1;
	
	@Column ( name = "EMail2")
	private String EMail2;
	
	@Column ( name = "Phone1")
	private String Phone1;
	
	@Column( name = "Phone2")
	private String Phone2;	
	
	@Column ( name = "Manager_Id")
	private String Manager_Id;
	
	@Column ( name = "LATI")
	private String LATI;	
	
	@Column ( name = "LONGI")
	private String LONGI;	
	
	@Column ( name = "Geofence")
	private String Geofence;
	
	@Column ( name = "ClusterID")	
	private long ClusterID;
	
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
		return updatedTS;
	}

	public void setUpdatedTS(Date updatedTS) {
		this.updatedTS = updatedTS;
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

	public String getStationCode() {
		return StationCode;
	}

	public void setStationCode(String stationCode) {
		StationCode = stationCode;
	}

	public String getStationName() {
		return StationName;
	}

	public void setStationName(String stationName) {
		StationName = stationName;
	}

	public String getStationType() {
		return StationType;
	}

	public void setStationType(String stationType) {
		StationType = stationType;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getEMail1() {
		return EMail1;
	}

	public void setEMail1(String eMail1) {
		EMail1 = eMail1;
	}

	public String getEMail2() {
		return EMail2;
	}

	public void setEMail2(String eMail2) {
		EMail2 = eMail2;
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

	public String getManager_Id() {
		return Manager_Id;
	}

	public void setManager_Id(String manager_Id) {
		Manager_Id = manager_Id;
	}

	public String getLATI() {
		return LATI;
	}

	public void setLATI(String lATI) {
		LATI = lATI;
	}

	public String getLONGI() {
		return LONGI;
	}

	public void setLONGI(String lONGI) {
		LONGI = lONGI;
	}

	public String getGeofence() {
		return Geofence;
	}

	public void setGeofence(String geofence) {
		Geofence = geofence;
	}

	public long getClusterID() {
		return ClusterID;
	}

	public void setClusterID(long clusterID) {
		ClusterID = clusterID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
