package org.example.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example"})
public class ProjectConfiguration {

    AnnotationConfigApplicationContext context(){
     return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
    }

}
