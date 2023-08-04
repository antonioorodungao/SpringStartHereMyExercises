package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Human h = context.getBean(Human.class);
        Human h2 = context.getBean("human2", Human.class);
        System.out.println(h);
        System.out.println(h2);

    }
}
