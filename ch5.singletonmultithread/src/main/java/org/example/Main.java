package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws InterruptedException {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        CommentService cs1 = context.getBean(CommentService.class);
        CommentService cs2 = context.getBean(CommentService.class);
        CommentService cs3 = context.getBean(CommentService.class);


        Thread consumer = new CommentServiceConsumerThread(context.getBean(CommentService.class));
        consumer.start();
        Thread t1 = new CommentServiceSupplierThread(cs1);
        t1.start();
        Thread t2 = new CommentServiceSupplierThread(cs2);
        Thread t3 = new CommentServiceSupplierThread(cs3);
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        consumer.join();

    }
}
