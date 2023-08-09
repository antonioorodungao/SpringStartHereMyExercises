package org.example.services;

import lombok.Getter;
import org.example.main.CommentProcessor;
import org.example.model.Comment;
import org.example.proxies.CommentNotificationProxy;
import org.example.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Getter
    private final CommentRepository commentRepository;
    AnnotationConfigApplicationContext context;


    public CommentService(CommentRepository commentRepository, AnnotationConfigApplicationContext context){
        this.commentRepository = commentRepository;
        this.context = context;
    }

    public void publishComment(Comment comment){

        /*CommentProcessor is a prototype. It is not managed by context therefore destruction or
        * @PreDestroy annotation will not work. The destruction methods will be handled by the calling
        * application itself. */


        CommentProcessor p = context.getBean(CommentProcessor.class) ;
        p.setComment(comment);
        p.processComment();
        p.validateComment();
        commentRepository.storeComment(comment);
    }

}
