package org.example;

import org.example.services.Comment;
import org.example.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        CommentService cs = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("Sample user only");
        comment.setText("Hello text");

        cs.deleteComment(comment);
        cs.editComment(comment);
        cs.publishComment(comment);
        cs.refreshComment(comment);
        try {
            cs.sampleThrowException();

        } catch (Exception e) {
            logger.info("Exception Handling");
        }
        cs.sampleThrowExceptionWithout();

    }
}
