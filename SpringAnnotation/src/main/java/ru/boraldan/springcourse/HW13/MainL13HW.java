package ru.boraldan.springcourse.HW13;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainL13HW {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Computer computer = context.getBean("computer", Computer.class);

        computer.startPlayer();



    }
}
