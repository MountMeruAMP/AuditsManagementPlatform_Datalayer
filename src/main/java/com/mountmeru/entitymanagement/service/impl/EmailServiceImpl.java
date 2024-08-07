package com.mountmeru.entitymanagement.service.impl;

import com.mountmeru.entitymanagement.dto.EmailDTO;
import com.mountmeru.entitymanagement.exceptions.EmailSendingException;
import com.mountmeru.entitymanagement.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl implements EmailService {

    public static Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailUserName;

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom(mailUserName);
            message.setFrom(new InternetAddress(mailUserName, "Mail from Meru - Audit Management Platform").toString());

            if (emailDTO.getToMultiple().length > 0) {
                message.setTo(emailDTO.getToMultiple());
            } else {
                message.setTo(emailDTO.getTo());
            }

            message.setSubject(emailDTO.getSubject());
            message.setText(emailDTO.getContent());

            mailSender.send(message);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendEmail(EmailDTO emailDTO, String template) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(new InternetAddress(mailUserName, "Mail from Meru - Audit Management Platform").toString());
            helper.setSubject(emailDTO.getSubject());

            if (emailDTO.getToMultiple() != null && emailDTO.getToMultiple().length > 0) {
                helper.setTo(emailDTO.getToMultiple());
            } else {
                helper.setTo(emailDTO.getTo());
            }

            // Set the email's content to be the HTML template
            helper.setText(template, true);

            // Add the inline image
            File imageFile = new File(emailDTO.getFileName());
            helper.addInline("image", imageFile);

            mailSender.send(message);
            log.info("Email sent with subject: " + emailDTO.getSubject());

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }

    @Override
    public void sendEmail(EmailDTO emailDTO, String template, String attachment) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(new InternetAddress(mailUserName, "Mail from Meru - Audit Management Platform").toString());
            helper.setSubject(emailDTO.getSubject());
            helper.setText(template, false);

            if (emailDTO.getToMultiple() != null && emailDTO.getToMultiple().length > 0) {
                helper.setTo(emailDTO.getToMultiple());
            } else {
                helper.setTo(emailDTO.getTo());
            }

            FileSystemResource file = new FileSystemResource(attachment);
            if (StringUtils.hasLength(file.getFilename())) {
                helper.addAttachment(file.getFilename(), file);
            }else {
                log.error("File not found: " + attachment);
            }

            mailSender.send(message);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
