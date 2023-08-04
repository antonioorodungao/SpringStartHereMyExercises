package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Human h = context.getBean("human", Human.class);
        Human h2 = context.getBean("human2", Human.class);
        Human h3 = context.getBean("human3", Human.class);
        System.out.println(h);
        System.out.println(h2);
        System.out.println(h3);
        context.close();

    }
}
