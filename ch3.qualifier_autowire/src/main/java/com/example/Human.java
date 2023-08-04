package com.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class Human {
    String name = "Antonio";
    Parrot pet;

    /* NOTE: With multiple instance of same class type, autowiring will match the
    *   name of the variable instead of type if the @Qualifier annotation is not used. */

    @Autowired
    public Human(Parrot parrot3){
        this.pet = parrot3;
    }
}

