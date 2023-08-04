package org.example.services;


import org.example.model.Comment;
import org.example.proxies.CommentNotificationProxy;
import org.example.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy notificationProxy;

    /*Note: Qualifier injects the intended object if two objects of same type exists in the context*/

    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy notificationProxy){
        this.commentRepository = commentRepository;
        this.notificationProxy = notificationProxy;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        notificationProxy.sendComment(comment);
    }
}
