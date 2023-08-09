package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CommentService {
    private static final Logger logger = LoggerFactory.getLogger(CommentService.class);
    /*Note: This is just a demo of Singleton object and the need for synchronization
    *  this will result to the logged count incorrect as multiple threads access the same property
    * of the bean */

//    private final List<Comment> sharedMap = new ArrayList<>();
    private final List<Comment> commentQueue = Collections.synchronizedList(new ArrayList<>());
    int count = 0;

    void queueComment(Comment comment) {
//        synchronized (this) {
            count++;
            commentQueue.add(comment);
            logger.info("Number of items in sharedMap: " + commentQueue.size());

//        }
    }

    void publishComments(){
        if(!commentQueue.isEmpty()){
            Comment c = commentQueue.remove(0);
            logger.info("This is the message: " + c.toString());
        }
    }

    boolean isQueueEmpty(){
        return commentQueue.isEmpty();
    }

}
