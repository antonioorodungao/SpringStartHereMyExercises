package org.example.services;

import org.example.model.Comment;
import org.example.proxies.CommentNotificationProxy;
import org.example.repositories.CommentRepository;

public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy notificationProxy;

    public CommentService(CommentRepository commentRepository, CommentNotificationProxy notificationProxy){
        this.commentRepository = commentRepository;
        this.notificationProxy = notificationProxy;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        notificationProxy.sendComment(comment);
    }
}
