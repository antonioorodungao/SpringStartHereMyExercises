package org.examples;

import org.examples.services.Comment;
import org.examples.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        CommentService commentService = context.getBean(CommentService.class);

        Comment c = new Comment();
        commentService.publishComment(c);
    }
}
