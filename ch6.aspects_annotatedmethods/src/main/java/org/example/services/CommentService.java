package org.example.services;

import org.example.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

    @ToLog
    public void editComment(Comment comment) {
        logger.info("editComment is executed. It is using @ToLog annotation");
    }

    @InterceptAfterReturning
    public void refreshComment(Comment comment) {
        logger.info("refreshComment is executed. Using custom annotation @InterceptAfterReturning.");
    }

    @InterceptAfter
    public void publishComment(Comment comment) {
        logger.info("publishComment is executed. Using custom annotation @InterceptAfter.");
    }


    @InterceptBefore
    public void deleteComment(Comment comment) {
        logger.info("deleteComment is executed. Using custom annotation @InterceptBefore.");
    }

    @InterceptOnThrow
    public void sampleThrowException() throws Exception {
        logger.info("sampleThrowException is executed. Using @InterceptOnThrow custom annotation. ");
        throw new Exception("Sample aspect annotation throwing exception");
    }

    @InterceptOnThrow
    public void sampleThrowExceptionWithout()  {
        logger.info("sampleThrowExceptionWithout is executed. Using @InterceptOnThrow custom annotation. Without Exception");
    }
}
