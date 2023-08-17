package com.example.ch9_applicationscope.services;


import com.example.ch9_applicationscope.model.Account;
import com.example.ch9_applicationscope.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Optional;

@Service
public class LoginValidationService {
    private static final Logger logger = LoggerFactory.getLogger(LoginValidationService.class);
    LoginCounterService loginCounter;
    UserRepository userRepository;
    UserSessionStore userSessionStore;


    public LoginValidationService(LoginCounterService loginCounter, UserRepository userRepository, UserSessionStore sessionStore) {
        this.loginCounter = loginCounter;
        this.userRepository = userRepository;
        this.userSessionStore = sessionStore;
    }

    public boolean isUserAuthorized(String username, String password){
        Optional<Account> op_account =  userRepository.getUser(username);
        if(op_account.isPresent() && op_account.get().getPassword().equals(password)){
            loginCounter.increment();
            logger.info("Users Logged in: " + loginCounter.getCount());
            userSessionStore.setAuthorized(true);
            userSessionStore.setAccount(op_account.get());
            return true;
        }else{
            return false;
        }

    }

    public String getLoggedUser(){
        return userSessionStore.getUserName();
    }
}
