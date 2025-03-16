package com.example.domain;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class Data {

    private Long id;
    private LocalDateTime timestamp;
    private String content;
    private DataStatus status;

    public Data() {
        this.id = null;
        this.timestamp = LocalDateTime.now();
        this.content = "";
        this.status = DataStatus.PENDING;
    }

    public Data(String content, DataStatus status) {
        this.id = null;
        this.timestamp = LocalDateTime.now();
        this.content = content;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DataStatus getStatus() {
        return status;
    }

    public void setStatus(DataStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}
