package ru.boraldan.springcourse.HW13_Neil;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.boraldan.springcourse.HW13_Neil.config.SpringConfig;

/**
 * @author Neil Alishev
 */
public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer.playMusic());

        context.close();
    }
}
