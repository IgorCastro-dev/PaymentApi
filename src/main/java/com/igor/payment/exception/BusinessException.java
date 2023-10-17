package com.igor.payment.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{
    private HttpStatus httpStatus;
    public BusinessException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
