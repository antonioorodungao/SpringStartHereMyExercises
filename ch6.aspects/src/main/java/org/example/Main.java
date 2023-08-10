package org.example;

import org.example.config.ProjectConfiguration;
import org.example.services.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        CommentService commentService = context.getBean(CommentService.class);
        Comment comment = new Comment();
        comment.setAuthor("Antonio Oro Dungao");
        comment.setText("Hello from Main. Exercise Aspects");
        var result = commentService.publishComment(comment);
        System.out.println(result);
        context.close();
    }
}
