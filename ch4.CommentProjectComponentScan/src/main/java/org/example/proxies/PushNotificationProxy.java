package org.example.proxies;

import org.example.model.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PUSH")
public class PushNotificationProxy implements CommentNotificationProxy{
    private static final Logger logger = LoggerFactory.getLogger(PushNotificationProxy.class);
    @Override
    public void sendComment(Comment comment) {

    logger.info("Sending through push notification " + comment);

    }
}
