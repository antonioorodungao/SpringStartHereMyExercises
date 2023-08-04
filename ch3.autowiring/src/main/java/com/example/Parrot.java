package com.example;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Parrot {
    String name;
    Human owner;

    @PostConstruct
    public void init() {
        setName("Quil");
    }

}
