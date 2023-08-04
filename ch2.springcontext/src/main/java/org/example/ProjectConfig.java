package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    @Primary
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Parrot1");
        return p;
    }

    //Same type instance in context
    @Bean
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Parrot2");
        return p;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
}
