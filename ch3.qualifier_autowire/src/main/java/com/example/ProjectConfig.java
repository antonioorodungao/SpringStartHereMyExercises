package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.logging.Logger;

@Configuration
@ComponentScan(basePackages = "com.example")
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
        logger.info("Setting the name of Parrot 2");
        p.setName("Parrot 3");
        return p;
    }
//
//    @Bean
//    @Primary
//    Human human(Parrot parrot){
//        Human human = new Human();
//        human.setName("Antonio");
//        human.setPet(parrot);
//        return human;
//    }
//
//    @Bean
//    Human human2(@Qualifier("parrot2")  Parrot parrot2){
//        Human human = new Human(parrot2);
//        human.setName("Adnan");
//        human.setPet(parrot2);
//        return human;
//    }

//
//    @Bean
//    Human human3(@Qualifier("parrot2")  Parrot pa){
//        Human human = new Human(parrot2);
//        human.setName("Adnan");
//        human.setPet(parrot2);
//        return human;
//    }


}
