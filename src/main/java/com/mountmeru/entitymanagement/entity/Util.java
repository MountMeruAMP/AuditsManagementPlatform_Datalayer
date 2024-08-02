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
@Table( name = "Util")
public class Util{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;
	
	public long getCounter() {
		return Counter;
	}

	public void setCounter(long counter) {
		Counter = counter;
	}

	@Column(name = "CreatedBy")
	private long CreatedBy;
	
	@Column(name = "Type")
	private String Type;	
	
	@Column(name = "Value")
	private String Value;
	
	@Column(name = "Placeholder_1")
	private String Placeholder_1;
	
	@Column(name = "Placeholder_2")
	private String Placeholder_2;
	
	@Column ( name="Placeholder_3")
	private String Placeholder_3;

	public long getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(long createdBy) {
		CreatedBy = createdBy;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public String getPlaceholder_1() {
		return Placeholder_1;
	}

	public void setPlaceholder_1(String placeholder_1) {
		Placeholder_1 = placeholder_1;
	}

	public String getPlaceholder_2() {
		return Placeholder_2;
	}

	public void setPlaceholder_2(String placeholder_2) {
		Placeholder_2 = placeholder_2;
	}

	public String getPlaceholder_3() {
		return Placeholder_3;
	}

	public void setPlaceholder_3(String placeholder_3) {
		Placeholder_3 = placeholder_3;
	}
}
