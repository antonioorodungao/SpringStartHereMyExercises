package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot(){
        Parrot p =  new Parrot();
        p.setName("Quil");
        return p;
    }

    @Bean
    @Primary
    Human human(Parrot parrot){
        Human human = new Human();
        human.setName("Antonio");
        human.setPet(parrot);
        return human;
    }

    @Bean
    Human human2(Parrot parrot){
        Human human = new Human();
        human.setName("Adnan");
        human.setPet(parrot);
        return human;
    }
}
