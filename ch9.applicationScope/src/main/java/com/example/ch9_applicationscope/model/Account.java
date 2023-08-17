package com.example.ch9_applicationscope.model;

import lombok.Data;

@Data
public class Account {
    String username;
    String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
