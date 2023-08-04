package org.example.proxies;


import org.example.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    private static final Logger logger = LoggerFactory.getLogger(EmailCommentNotificationProxy.class);

    @Override
    public void sendComment(Comment comment) {
        logger.info("Sending comment via Email: " + comment);
    }
}
