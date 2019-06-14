package com.salonbackend.salon.exception;

public class EmployeeNotFoundException extends Throwable {
    public EmployeeNotFoundException(String exception) {
        super(exception);
    }
}