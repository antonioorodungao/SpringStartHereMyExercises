package com.example.ch9_sessionscope;

import com.example.ch9_sessionscope.service.UserValidator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    UserValidator userValidator;

    @Override
    public void run(String... args) throws Exception {

            userValidator.addUser("Antonio", "123");
            userValidator.addUser("Adnan", "123");
    }

    public DataInitializer(UserValidator validator) {
        this.userValidator = validator;
    }


}
