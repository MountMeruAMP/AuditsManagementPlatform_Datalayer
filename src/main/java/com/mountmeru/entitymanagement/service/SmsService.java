package com.mountmeru.entitymanagement.service;

import org.springframework.stereotype.Service;

@Service
public interface SmsService {

    String sendOtp(String phone, String otp);
}
