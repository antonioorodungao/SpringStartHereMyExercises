package org.example.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentService {
    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);


    public String publishComment(Comment comment){

        logger.info("Publishing comment: " + comment.getText());
        return "Publish Comment OK";

    }
}
