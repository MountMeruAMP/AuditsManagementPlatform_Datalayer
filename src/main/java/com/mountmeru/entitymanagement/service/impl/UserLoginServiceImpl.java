package com.mountmeru.entitymanagement.service.impl;

import java.util.List;
import java.util.Random;

import javax.management.RuntimeErrorException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mountmeru.entitymanagement.dto.UsersDTO;
import com.mountmeru.entitymanagement.entity.UserLogin;
import com.mountmeru.entitymanagement.repository.UserLoginRepository;
import com.mountmeru.entitymanagement.service.UserLoginService;
import com.mountmeru.entitymanagement.service.UsersService;
import com.mountmeru.entitymanagement.utils.DateUtils;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	org.slf4j.Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);
	
	@Value("${application.environment}")
	String runTimeEnv;
	
	@Value("${application.otp.length}")
	String otpLength;
	
	@Value("${application.otp.defaultvalue}")
	String defaultotpvalue;
	
	@Value("${application.otp.otpexptiredtime}")
	String otpexptiredtime;
	
	@Autowired 
	DateUtils oDateUtils;
	
	@Autowired
	UsersService usersService;	
	
	UserLoginRepository oUserLoginRepository;
	public UserLoginServiceImpl(UserLoginRepository oUserLoginRepository)
	{
		this.oUserLoginRepository = oUserLoginRepository;
	}
	
	@Override
	public String generateOTP(long userId) {
		// 1.Generate New OTP
		String newOTP = "DEV".equalsIgnoreCase(runTimeEnv)?defaultotpvalue:getNewOTP(Integer.valueOf(otpLength));
		
		// 2. Save it in the database table.
		UserLogin oUserLogin = new UserLogin();
		oUserLogin.setId(userId);
		oUserLogin.setOtp(newOTP);
		oUserLogin.setCreatedTs(oDateUtils.getCurrentTimeStamp());
		oUserLogin.setLogin_Successful("N");
		try {
			UserLogin savedUserLogin = oUserLoginRepository.save(oUserLogin);			
			log.debug("User OTP saved in the database {} ", savedUserLogin.toString());
		}
		catch(Exception e)
		{
			throw new RuntimeErrorException(new Error("Exception occurred while genetating the OTP. Please try again."));
		}	
		
		// 3. Call the Service Method of the OTP Service Provider.
		//UsersDTO oUsersDTO = usersService.getUsersByUserId(userId);
		//log.info(" The OTP should be Sent to the User with Phone Number {}", oUsersDTO.getPhone1());	
		// TODO create a SERVICE CALL.
		// Text Message Body
		// Text Message OTP
		// Phone Number
		return new String("Ok");
	}
	@Override
	public UsersDTO validateUserForUserIdAndOTP(long userId, String otp) {
		// We got the record for User id and OTP
		List<UserLogin> alUserLogin = oUserLoginRepository.findByUserIdOTP(String.valueOf(userId)); 
		// Now check if the OTP has expired.
		if(null ==alUserLogin || alUserLogin.size()==0  ||  StringUtils.isEmpty(otp) || !otp.equalsIgnoreCase(alUserLogin.get(0).getOtp()))
		{
			throw new RuntimeErrorException(new Error("Invalid OTP. Please regenerate the OTP to login."));
		}
		long otpExpTime = alUserLogin.get(0).getCreatedTs().getTime()+(Integer.parseInt(otpexptiredtime)*60*1000);
		long systime = System.currentTimeMillis();
		log.info("OTP Expired time {}", otpExpTime );
		log.info("System time {}", System.currentTimeMillis());
		if( otpExpTime < systime)
		{
			// OTP Expired
			throw new RuntimeErrorException(new Error("OTP has expired. Please regenerate the OTP."));
		}
		else
		{
			// Valid OTP.
			alUserLogin.get(0).setLogin_Successful("Y");
			try {
				UserLogin savedUserLogin = oUserLoginRepository.save(alUserLogin.get(0));
				
				//TODO APIS for Dash-board.
				// User Id from savedUserLogin
				// You need to get role of the User. --> Users --> Role Id --> Roles Table ( Role Name )
				// As per the role name you need branch out the codes.
				
			}
			catch(Exception e)
			{
				throw new RuntimeErrorException(new Error("Exception occurred while validating the OTP. Please try again."));
			}
			return usersService.getUsersByUserId(userId);
		}
	}
	/**
	 * This method generated the new OTP.
	 * @param len
	 * @return
	 */
	private String getNewOTP(int len) 
    { 
		log.debug("Generating OTP using random(): ");   
        // Using numeric values 
        String numbers = "0123456789"; 
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[len]; 
  
        for (int i = 0; i < len; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        
        return new String(otp);
    }
}
