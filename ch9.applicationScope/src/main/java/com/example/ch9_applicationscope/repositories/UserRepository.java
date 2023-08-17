package com.example.ch9_applicationscope.repositories;

import com.example.ch9_applicationscope.model.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class UserRepository {

    HashMap<String, Account> accounts = new HashMap<>();

    public void addUser(Account account){
        accounts.put(account.getUsername(), account);
    }

    public Optional<Account> getUser(String username){
        return Optional.ofNullable(accounts.get(username));
    }
}
