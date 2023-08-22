package org.example.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Purchase {
    private String product;
    private BigDecimal price;
    private int id;
}
