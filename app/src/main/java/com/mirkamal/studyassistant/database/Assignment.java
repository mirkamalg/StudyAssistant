package com.mirkamal.studyassistant.database;

import java.time.LocalDateTime;

public class Assignment {

    private String subject, topic;
    private LocalDateTime deadline;

    public Assignment(String subject, String topic, LocalDateTime deadline) {
        this.subject = subject;
        this.topic = topic;
        this.deadline = deadline;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}
