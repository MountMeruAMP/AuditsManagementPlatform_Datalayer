package com.mountmeru.entitymanagement.validators;

import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mountmeru.entitymanagement.dto.UsersDTO;

@Service
public class UserValidator extends CommonValidator{
	
	public void validateUser(UsersDTO user)
	{
	 // validateEmail(user.getEmail()); 
	 // validatePhone(user.getPhone1());
	 // validatePhone(user.getPhone2());
	 // validateProvince(user.getProvince());
	 // validateCountry(user.getCountry());
	 // validateZIPCode(user.getZipCode());
	 // validateDateOfBirth(user.getDob());
	 // odateUtils.validateEffectiveAndThroughDates(user.getEffectiveDate(), user.getThroughDate());
	}
	public void validateDateOfBirth(Date dob)
	{
		if(StringUtils.isEmpty(dob))
			throw new RuntimeErrorException(new Error("Date of Birth field cannot be Empty"));
		
		if(1== odateUtils.compareTwoDatesAsString(odateUtils.parseDateToString(dob), odateUtils.getTodaysDateAsString()))
			throw new RuntimeErrorException(new Error("Date of birth cannot be after today's Date"));
	}	
}
