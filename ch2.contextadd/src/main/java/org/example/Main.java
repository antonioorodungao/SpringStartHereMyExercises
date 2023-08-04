package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Supplier<Parrot> supplier = () -> {
            Parrot x = new Parrot();
            x.setName("Antonio");
            return x;
        };

        context.registerBean("parrot_Antonio", Parrot.class,supplier );

        System.out.println(context.getBean("parrot_Antonio"));

    }
}
