package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Human h = context.getBean(Human.class);
        System.out.println(h);
        context.close();
    }
}
