package org.example.proxies;

import org.example.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PushNotificationProxy implements CommentNotificationProxy{
    private static final Logger logger = LoggerFactory.getLogger(PushNotificationProxy.class);
    @Override
    public void sendComment(Comment comment) {

    logger.info("Sending through push notification " + comment);

    }
}
