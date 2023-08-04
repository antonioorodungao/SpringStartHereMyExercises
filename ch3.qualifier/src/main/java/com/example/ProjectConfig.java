package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.logging.Logger;

@Configuration
public class ProjectConfig {
    Logger logger = Logger.getLogger(ProjectConfig.class.getName());

    @Bean
    Parrot parrot(){
        Parrot p =  new Parrot();
        logger.info("Setting the name of Parrot Default");
        p.setName("Parrot Default");
        return p;
    }

    @Bean
    Parrot parrot2(){
        Parrot p =  new Parrot();
        logger.info("Setting the name of Parrot 2");
        p.setName("Parrot 2");
        return p;
    }

    @Bean
    Parrot parrot3(){
        Parrot p =  new Parrot();
        logger.info("Setting the name of Parrot 3");
        p.setName("Parrot 3");
        return p;
    }

    @Bean
    Human human(Parrot parrot){
        Human human = new Human();
        human.setName("Antonio");
        human.setPet(parrot);
        return human;
    }

    @Bean
    Human human2(@Qualifier("parrot2")  Parrot parrot2){
        Human human = new Human();
        human.setName("Adnan");
        human.setPet(parrot2);
        return human;
    }

    /*Note: If no qualifier is used, Spring will autowire based on the
    *  method variable name */
    @Bean
    Human human3(Parrot parrot3){
        Human human = new Human();
        human.setName("Ali");
        human.setPet(parrot3);
        return human;
    }
}
