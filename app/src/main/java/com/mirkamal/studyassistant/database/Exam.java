package com.mirkamal.studyassistant.database;

import java.time.LocalDateTime;

public class Exam {

    private String subject;
    private LocalDateTime date;

    public Exam(String subject, LocalDateTime date) {
        this.subject = subject;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
