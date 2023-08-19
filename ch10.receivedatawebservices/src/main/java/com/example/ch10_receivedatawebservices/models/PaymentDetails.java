package com.example.ch10_receivedatawebservices.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDetails {
    BigDecimal amount;
    String transactionID;
    String message;
}
