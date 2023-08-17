package com.example.ch9_applicationscope;

import com.example.ch9_applicationscope.model.Account;
import com.example.ch9_applicationscope.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initialization implements CommandLineRunner {

    public Initialization(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.addUser(new Account("Antonio", "123"));
        userRepository.addUser(new Account("Adnan", "123"));

    }
}
