package com.example.ch11_usingresttemplate.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Payment {
    BigDecimal amount;
    String id;
}
