package com.mountmeru.entitymanagement.controller;

import com.mountmeru.entitymanagement.dto.EmailDTO;
import com.mountmeru.entitymanagement.service.EmailService;
import com.mountmeru.entitymanagement.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailTestController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SmsService smsService;


    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendSimpleEmail(@RequestBody EmailDTO emailDTO) {

        emailService.sendEmail(emailDTO);

        return "Email sent successfully";
    }

    @PostMapping(value = "/send/template", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendEmailWithTemplate(@RequestBody EmailDTO emailDTO) {


        // Create HTML content with inline image
        String content = "<html><body>" +
                "<p>" + emailDTO.getContent() + "</p>" +
                "<img src='cid:image' width='640' height='480'>" +
                "</body></html>";

        emailService.sendEmail(emailDTO, content);

        return "Email sent successfully";
    }

    @PostMapping(value = "/send/attachment", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendEmailWithAttachment(@RequestBody EmailDTO emailDTO) {


        emailService.sendEmail(emailDTO, emailDTO.getContent(), emailDTO.getFileName());

        return "Email sent successfully";
    }

    @GetMapping(value = "/testOtp", produces = MediaType.APPLICATION_JSON_VALUE)
    public String testingOtpSms(@RequestParam String phone, @RequestParam String otp) {

        return smsService.sendOtp(phone, otp);
    }
}
