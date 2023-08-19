package com.example.ch10_restwebservices.models;

import lombok.Data;

@Data
public class Country {
    String countryName;
    Integer countryCode;

    public Country(String countryName, Integer countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }
}
