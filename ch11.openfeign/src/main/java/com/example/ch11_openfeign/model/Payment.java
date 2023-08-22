package com.example.ch11_openfeign.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment {
    BigDecimal amount;
    String id;
}
