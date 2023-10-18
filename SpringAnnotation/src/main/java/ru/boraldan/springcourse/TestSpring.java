package ru.boraldan.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        // Les 9
//        TranseVocal transeVocal = context.getBean("transeVocal", TranseVocal.class);
//        MusicPlayer musicPlayer = new MusicPlayer(transeVocal);
//        musicPlayer.playMusic();

//        MusicPlayerL10 musicPlayerL10 = context.getBean("musicPlayerL10", MusicPlayerL10.class);
//        musicPlayerL10.playMusic();

//        MusicPlayerL10 musicPlayerL101 = context.getBean("musicPlayerL10", MusicPlayerL10.class);
//        musicPlayerL101.playMusic();

//        Computer computerL10 = context.getBean("computer", Computer.class);
//        computerL10.startPlayer();

        MusicPlayerL10 musicPlayerL10 = context.getBean("musicPlayerL10", MusicPlayerL10.class);
        musicPlayerL10.playMusic();
        context.close();

    }
}
