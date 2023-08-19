package com.example.ch10_adviceonwebservice.advices;

import lombok.Data;

@Data
public class ErrorDetails {
    String errorCode;
    String errorMessage;

    public ErrorDetails(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
