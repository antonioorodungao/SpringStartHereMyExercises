package org.example.config;

import org.example.aspects.LoggingAspect;
import org.example.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    CommentService commentService(){
        return new CommentService();
    }

    @Bean
    LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}
