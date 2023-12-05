package com.assignment.addressbook.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class CustomErrorModel {
    @JsonProperty("errorCode")
    private String errorCode;

    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public CustomErrorModel(String errorCode, String errorMessage, LocalDateTime timestamp) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }
}
