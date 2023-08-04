package org.example.main;

import org.example.config.ProjectConfiguration;
import org.example.model.Comment;
import org.example.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        CommentService cs = context.getBean("commentService", CommentService.class);
        Comment c = new Comment("Antonio", "Hello from Antonio");
        cs.publishComment(c);
        context.close();
    }
}
