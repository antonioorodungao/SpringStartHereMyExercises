package org.example.services;

import lombok.Getter;
import org.example.model.Comment;
import org.example.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Getter
@Service
public class UserService {
    private final CommentRepository commentRepository;

    public UserService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
    }

}
