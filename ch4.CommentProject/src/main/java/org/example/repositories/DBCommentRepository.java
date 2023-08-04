package org.example.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.example.model.Comment;


public class DBCommentRepository implements CommentRepository {
    private static final Logger logger = LoggerFactory.getLogger(DBCommentRepository.class);
    @Override
    public void storeComment(Comment comment) {
        logger.info("Storing comment..." + comment);
    }
}
