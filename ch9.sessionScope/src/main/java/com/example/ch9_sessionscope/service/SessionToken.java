package com.example.ch9_sessionscope.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
@Data
public class SessionToken {
    private static final Logger logger = LoggerFactory.getLogger(SessionToken.class);
    private Boolean userValid;
    private String username;
    private String password;

    public String getIdentity(){
        return "" + System.identityHashCode(this);
    }

    @PostConstruct
    public void construct(){
        logger.info("Constructing Session token.");

    }

    @PreDestroy
    public void cleanup(){
        logger.info("Cleaning up token.");
    }
}
