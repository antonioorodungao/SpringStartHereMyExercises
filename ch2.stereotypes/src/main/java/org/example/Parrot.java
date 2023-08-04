package org.example;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Data
@Component
public class Parrot {
    String name = "Component";

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }

    @PreDestroy
    public void cleanUp(){
        System.out.println("Cleaning up " + this);
    }

    @PostConstruct
    public void build(){
        System.out.println("Building up " + this);
        this.name = "Kiki";
    }
}
