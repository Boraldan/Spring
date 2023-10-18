package ru.boraldan.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

//        TestBean testBean = context.getBean("testBean", TestBean.class);
//        System.out.println(testBean.getName());
//
//        Music music = context.getBean("musicBean", Music.class);
//        MusicPlayer musicPlayer = new MusicPlayer(music);

//        MusicPlayer musicPlayer = context.getBean("musicPlayer3", MusicPlayer.class);
//        MusicPlayer musicPlayerLes6 = context.getBean("musicPlayerList", MusicPlayer.class);

//        musicPlayer.playMusic();
//        System.out.println(musicPlayer.getName() + ". Громкость: " + musicPlayer.getVolume());

//        musicPlayerLes6.playMusicList();

//        ClassicalMusic classicalMusicLes8 = context.getBean("musicBean2",ClassicalMusic.class);
//        System.out.println(classicalMusicLes8.getSong());
//
//        ClassicalMusic classicalMusicLes81 = context.getBean("musicBean2",ClassicalMusic.class);
//        System.out.println(classicalMusicLes81.getSong());
//
//        ClassicalMusic classicalMusicLes82 = context.getBean("musicBean2",ClassicalMusic.class);
//        System.out.println(classicalMusicLes82.getSong());

        ClassicalMusicL8Factory classicalMusicL8Factory = context.getBean("musicBean8", ClassicalMusicL8Factory.class);

        System.out.println(classicalMusicL8Factory.getSong());
        context.close();
    }
}
