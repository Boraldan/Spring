package ru.boraldan.springcourse.Les13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainL13 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Computer computer = context.getBean("computer", Computer.class);

        computer.startPlayer();



    }
}
