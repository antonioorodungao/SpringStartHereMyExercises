package com.example.ch9_sessionscope.repository;

import com.example.ch9_sessionscope.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class UserLogins {
    ArrayList<Account> users = new ArrayList();

    public Optional<Account> getUser(String username){
        Account a = new Account(username, "");
        a.setUsername(username);
        int index = users.indexOf(a);
        if(index < 0){
            return Optional.empty();
        }else {
            return Optional.ofNullable(users.get(index));
        }
    }

    public void addUsers(String username, String password){
        Account account = new Account(username, password);
        users.add(account);
    }

}
