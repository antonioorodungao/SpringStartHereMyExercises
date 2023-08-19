package com.example.ch10_restwebservices.exceptions;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class InsufficientBalanceException extends Exception{
    private final String message = "Insufficient balance";

}
