package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentServiceConsumerThread  extends Thread{
    CommentService commentService;
    private static final Logger logger = LoggerFactory.getLogger(CommentServiceConsumerThread.class);
    public CommentServiceConsumerThread(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void run() {
        logger.info("Starting consumer thread");
        while(true){
            commentService.publishComments();
        }
    }
}
