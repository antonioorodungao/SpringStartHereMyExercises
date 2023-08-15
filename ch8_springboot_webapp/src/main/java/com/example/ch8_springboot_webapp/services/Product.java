package com.example.ch8_springboot_webapp.services;

import lombok.Data;

@Data
public class Product {

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    private String name;
    private Double price;
}
