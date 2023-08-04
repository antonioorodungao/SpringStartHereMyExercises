package com.example;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Data
@Component
public class Parrot {
    String name;
    Logger logger = Logger.getLogger(Parrot.class.getName());

//    @PostConstruct
//    public void init(){
//        logger.info("Inside Post Construct Init");
//        setName("Default Name");
//    }

}
