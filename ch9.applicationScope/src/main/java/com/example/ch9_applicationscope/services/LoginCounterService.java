package com.example.ch9_applicationscope.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
@Service
public class LoginCounterService {

    private static final Logger logger = LoggerFactory.getLogger(LoginCounterService.class);
    
    private int count;

    public void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }

    @PostConstruct
    void constructLog() {
        logger.info(String.format("Constructing %s with id %s ", this.getClass().getName(), System.identityHashCode(this)));
    }

    @PreDestroy
    void cleanup() {
        logger.info(String.format("Deconstructing %s with id %s ", this.getClass().getName(), System.identityHashCode(this)));
    }
}
