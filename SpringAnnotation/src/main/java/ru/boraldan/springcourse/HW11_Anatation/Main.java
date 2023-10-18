package ru.boraldan.springcourse.HW11_Anatation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Player player = context.getBean("player", Player.class);
        System.out.println(player.name);
        player.playMusic(MyEnam.ROCK);
        player.playMusic(MyEnam.CLASSIC);
        context.close();

    }
}
