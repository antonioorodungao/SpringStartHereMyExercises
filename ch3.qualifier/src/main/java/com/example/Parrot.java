package com.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Data
public class Parrot {
    String name;
    Logger logger = Logger.getLogger(Parrot.class.getName());

    @PostConstruct
    public void init(){
        logger.info("Initializing " + getName() +" parrot.");
    }

    @PreDestroy
    public  void clearcache(){
        logger.info("Releasing " + getName() +" parrot.");
    }

}
