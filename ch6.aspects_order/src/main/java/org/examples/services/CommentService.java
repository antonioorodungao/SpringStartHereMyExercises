package org.examples.services;


import org.examples.annotations.ToLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @ToLog
    public void publishComment(Comment comment){
        logger.info("Calling the publish comment.");

    }
}
