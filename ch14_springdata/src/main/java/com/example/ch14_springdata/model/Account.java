package com.example.ch14_springdata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class Account {
    @Id
    long id;
    String name;

    BigDecimal balance;
}
