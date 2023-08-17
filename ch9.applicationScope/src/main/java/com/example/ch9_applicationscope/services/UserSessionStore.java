package com.example.ch9_applicationscope.services;

import com.example.ch9_applicationscope.model.Account;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
@Setter
public class UserSessionStore {

    private static final Logger logger = LoggerFactory.getLogger(UserSessionStore.class);

    private Account account;
    private boolean isAuthorized;

    public String getUserName(){
        return account.getUsername();
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
