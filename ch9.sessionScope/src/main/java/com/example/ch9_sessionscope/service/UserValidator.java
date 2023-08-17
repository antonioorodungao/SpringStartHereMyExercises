package com.example.ch9_sessionscope.service;

import com.example.ch9_sessionscope.model.Account;
import com.example.ch9_sessionscope.repository.UserLogins;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserValidator {
    private final UserLogins userLogins;

    public UserValidator(UserLogins userLogins){
        this.userLogins = userLogins;
    }

    public boolean isUserValid(String username, String password){
        Optional<Account> login = userLogins.getUser(username);
//        return login.map(account -> account.getPassword().equals(password)).orElse(false);
//
        if(login.isEmpty()){

            return false;
        }else{
            return login.get().getPassword().equals(password);
        }

    }

    public void addUser(String username, String password){
        userLogins.addUsers(username, password);
    }

    public SessionToken getToken(){
        return new SessionToken();
    }
}
