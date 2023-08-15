package org.examples;

import org.examples.aspects.LogAspect;
import org.examples.aspects.SecurityAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org.examples.services"})
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }

    @Bean
    public SecurityAspect securityAspect(){
        return new SecurityAspect();
    }
}
