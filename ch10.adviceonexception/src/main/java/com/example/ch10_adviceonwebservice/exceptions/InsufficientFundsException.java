package com.example.ch10_adviceonwebservice.exceptions;


import lombok.Data;

@Data
public class InsufficientFundsException extends Exception {
    String message = "Insufficient funds to perform transaction";

    @Override
    public String toString() {
        return "InsufficientFundsException{" +
                "message='" + message + '\'' +
                '}';
    }
}
