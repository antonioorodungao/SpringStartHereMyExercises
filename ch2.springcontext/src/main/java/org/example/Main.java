package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean("parrot",Parrot.class);
        System.out.println(p);

        Parrot p2 = context.getBean("parrot2",Parrot.class);
        System.out.println(p2);


        Parrot p_default = context.getBean(Parrot.class);
        System.out.println("default: " +  p_default);

        String hello = context.getBean("hello", String.class);
        System.out.println(hello);

        Integer ten = context.getBean("ten", Integer.class);
        System.out.println(ten);

    }
}