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
@Table( name = "Countries")
public class Countries {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;
	
	@Column(name = "CountryCode")
	private String CountryCode;
	
	@Column(name = "Country_Name")
	private String Country_Name;
	
	@Column(name = "Country_ShortName")
	private String Country_ShortName;
	
	

	@Column(name = "Manager_Id")
	private long Manager_Id;
	
	@Column ( name="Status")
	private String Status;

	public long getCounter() {
		return Counter;
	}

	public void setCounter(long counter) {
		Counter = counter;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public String getCountry_Name() {
		return Country_Name;
	}

	public void setCountry_Name(String country_Name) {
		Country_Name = country_Name;
	}

	public String getCountry_ShortName() {
		return Country_ShortName;
	}

	public void setCountry_ShortName(String country_ShortName) {
		Country_ShortName = country_ShortName;
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
}
