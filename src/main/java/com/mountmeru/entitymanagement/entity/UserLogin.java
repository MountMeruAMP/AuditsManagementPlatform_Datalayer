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
@Table(name = "Userlogin")
public class UserLogin {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Counter;	

	@Column(name = "Id")
	private long Id;
	
	@Column(name = "Otp")
	private String Otp;
	
	@Column(name ="Created_Time")
	private Date createdTs;
	
	@Column(name="Login_Successful")
	private String Login_Successful;
	
	public long getCounter() {
		return Counter;
	}

	public void setCounter(long counter) {
		Counter = counter;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getOtp() {
		return Otp;
	}

	public void setOtp(String otp) {
		Otp = otp;
	}

	public Date getCreatedTs() {
		return createdTs;
	}

	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}

	public String getLogin_Successful() {
		return Login_Successful;
	}

	public void setLogin_Successful(String login_Successful) {
		Login_Successful = login_Successful;
	}
}
