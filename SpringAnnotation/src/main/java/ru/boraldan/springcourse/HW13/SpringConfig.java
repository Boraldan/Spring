package ru.boraldan.springcourse.HW13;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("ru.boraldan.springcourse.HW13")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public TranseVocal transeVocal() {
        return new TranseVocal();
    }

    @Bean
    public Jass jass() {
        return new Jass();
    }

    @Bean
    public Rock rock() {
        return new Rock();
    }

    @Bean
    public MusicList musicList() {
        MusicList musicList = new MusicList();
        musicList.setMusic(classicalMusic());
        musicList.setMusic(rock());
        musicList.setMusic(transeVocal());
        return musicList;
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }

    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }
}
