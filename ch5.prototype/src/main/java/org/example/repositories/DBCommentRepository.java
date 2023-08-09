package org.example.repositories;

import org.example.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DBCommentRepository implements CommentRepository{
    private static final Logger logger = LoggerFactory.getLogger(DBCommentRepository.class);
    @Override
    public void storeComment(Comment comment) {
        logger.info("Storing comment..." + comment);
    }
}
