package com.salonbackend.salon.model;

import org.springframework.http.HttpStatus;

public class EmployeeResponse {

    private String messageType;
    private String message;
    private HttpStatus status;

    public EmployeeResponse() {

    }

    public EmployeeResponse(HttpStatus internalServerError, String errorType, String errorMessage) {
        this.messageType = errorType;
        this.message = errorMessage;
        this.status = internalServerError;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
