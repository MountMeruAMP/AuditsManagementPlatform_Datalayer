package com.mountmeru.entitymanagement.service;

import com.mountmeru.entitymanagement.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendEmail(EmailDTO emailDTO);
    void sendEmail(EmailDTO emailDTO, String template);
    void sendEmail(EmailDTO emailDTO, String template, String attachment);
}
