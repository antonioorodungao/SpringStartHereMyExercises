package com.example.ch9_requestscope.services;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
//@Data
public class LoginProcessor {

    private static final Logger logger = LoggerFactory.getLogger(LoginProcessor.class);
    private String username;
    private String password;

    public boolean isValidLogin() {
        logger.info("Object Hash" + this.hashCode());

        if (getUsername().equals("Antonio") && getPassword().equals("123")) {
            return true;
        } else {
            return false;
        }

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
