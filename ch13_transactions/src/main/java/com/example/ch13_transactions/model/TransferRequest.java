package com.example.ch13_transactions.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    BigDecimal amount;
    long sourceAccountId;
    long destinationAccountId;

}
