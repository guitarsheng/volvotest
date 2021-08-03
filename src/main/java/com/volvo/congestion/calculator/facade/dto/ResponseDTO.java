package com.volvo.congestion.calculator.facade.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDTO implements Serializable {
    boolean success=true;
    Object data;
    String message;
    int errorCode;

    public ResponseDTO() {
    }

    public ResponseDTO(Object data) {
        this.data = data;
    }
}
