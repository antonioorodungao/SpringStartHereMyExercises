package com.example.ch13_transactions.model;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@Data
public class Account {
    @Id
    long id;
    String name;
    BigDecimal balance;
}
