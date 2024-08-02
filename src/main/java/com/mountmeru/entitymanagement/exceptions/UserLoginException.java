package com.mountmeru.entitymanagement.exceptions;

public class UserLoginException extends RuntimeException{
	public UserLoginException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	public UserLoginException(String errorMessage) {
		super(errorMessage);
	}
}
