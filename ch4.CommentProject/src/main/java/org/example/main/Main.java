package org.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.example.config.ProjectConfiguration;
import org.example.model.Comment;
import org.example.services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        CommentService cs = context.getBean("commentService", CommentService.class);
        Comment c = new Comment("Antonio", "Hello from Antonio");
        cs.publishComment(c);
        context.close();
    }
}
