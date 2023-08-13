package org.example;

import org.example.aspects.LogAspect;
import org.example.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    @Bean
    CommentService commentService(){
        return new CommentService();
    }

    @Bean
    LogAspect logAspect(){
        return new LogAspect();
    }
}
