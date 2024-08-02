package com.mountmeru.entitymanagement.validators;

public interface BaseValidator {
	void validateEmail(String email) throws RuntimeException;
	void validatePhone(String phone) throws RuntimeException;
	void validateProvince(String province) throws RuntimeException;
	void validateCountry(String country) throws RuntimeException;
	void validateZIPCode(String zipCode) throws RuntimeException;
}
