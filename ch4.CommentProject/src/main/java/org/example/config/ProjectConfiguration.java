package org.example.config;

import org.example.proxies.CommentNotificationProxy;
import org.example.proxies.EmailCommentNotificationProxy;
import org.example.proxies.PushNotificationProxy;
import org.example.repositories.CommentRepository;
import org.example.repositories.DBCommentRepository;
import org.example.services.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Bean
    CommentRepository commentRepository(){
        return new DBCommentRepository();
    }

    @Bean
    CommentNotificationProxy emailNotificationProxy(){
        return new EmailCommentNotificationProxy();
    }

    @Bean
    CommentNotificationProxy pushNotificationProxy(){
        return new PushNotificationProxy();

    }

    @Bean
    CommentService commentService(CommentRepository commentRepository, @Qualifier("pushNotificationProxy") CommentNotificationProxy commentNotificationProxy){
        return new CommentService(commentRepository, commentNotificationProxy);
    }

}
