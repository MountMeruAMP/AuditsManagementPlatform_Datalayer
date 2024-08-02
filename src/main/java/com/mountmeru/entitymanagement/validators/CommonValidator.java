package com.mountmeru.entitymanagement.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.mountmeru.entitymanagement.utils.Constants;
import com.mountmeru.entitymanagement.utils.DateUtils;

public class CommonValidator implements BaseValidator{
	@Autowired
	DateUtils odateUtils;
	
	@Override
	public void validateEmail(String email) throws RuntimeException {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(email))
			return;
		
		 Pattern pattern = Pattern.compile(Constants.emailregex);
		 Matcher matcher = pattern.matcher(email);
		 if( !matcher.matches())
			 throw new RuntimeErrorException(new Error("Invalid Email Id."));
	}

	@Override
	public void validatePhone(String phone) throws RuntimeException {
		if(StringUtils.isEmpty(phone))
			return;
		Pattern pattern = Pattern.compile(Constants.phoneRegx);
		Matcher matcher = pattern.matcher(phone);
		if( !matcher.matches())
			throw new RuntimeErrorException(new Error("Invalid Phone Number."));
	}

	@Override
	public void validateProvince(String province) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateCountry(String country) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateZIPCode(String zipCode) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}
}
