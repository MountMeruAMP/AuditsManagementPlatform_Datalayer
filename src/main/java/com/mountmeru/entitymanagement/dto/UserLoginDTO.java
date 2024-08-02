package com.mountmeru.entitymanagement.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserLoginDTO {	
	
	private long counter;	
	private long id;	// User ID
	private String otp;	 // Generated OTP
	private String loginsuccessful;
	private Date createdts;
	
	public long getCounter() {
		return counter;
	}
	public void setCounter(long counter) {
		this.counter = counter;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Date getCreatedts() {
		return createdts;
	}
	public void setCreatedts(Date createdts) {
		this.createdts = createdts;
	}
	public String getLoginsuccessful() {
		return loginsuccessful;
	}
	public void setLoginsuccessful(String loginsuccessful) {
		this.loginsuccessful = loginsuccessful;
	}
}
