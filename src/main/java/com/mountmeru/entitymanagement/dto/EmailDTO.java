package com.mountmeru.entitymanagement.dto;

import java.io.Serializable;

public class EmailDTO implements Serializable {

    private String from;
    private String to;

    private String[] toMultiple;
    private String subject;
    private String userName;
    private String content;

    private String fileName; // along with the path and extension.

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getToMultiple() {
        return toMultiple;
    }

    public void setToMultiple(String[] toMultiple) {
        this.toMultiple = toMultiple;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
