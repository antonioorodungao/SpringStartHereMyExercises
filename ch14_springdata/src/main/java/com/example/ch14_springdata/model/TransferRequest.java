package com.example.ch14_springdata.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    BigDecimal amount;
    long sourceAccountId;
    long destinationAccountId;
}
