package com.mountmeru.entitymanagement.exceptions;

import jakarta.mail.MessagingException;
import org.springframework.mail.MailException;

public class EmailSendingException extends MessagingException {

    public EmailSendingException(String msg) {
        super(msg);
    }

    public EmailSendingException(String s, Exception e) {
        super(s, e);
    }

}
