package com.volvo.congestion.calculator.domain;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
