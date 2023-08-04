package org.example.main;

import org.example.model.Comment;
import org.example.proxies.EmailCommentNotificationProxy;
import org.example.repositories.DBCommentRepository;
import org.example.services.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        CommentService cs = new CommentService(new DBCommentRepository(), new EmailCommentNotificationProxy());
        Comment c = new Comment("Antonio", "Hello from Antonio");
        cs.publishComment(c);

    }
}
