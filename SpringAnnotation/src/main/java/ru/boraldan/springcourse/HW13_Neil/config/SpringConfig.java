package ru.boraldan.springcourse.HW13_Neil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import ru.boraldan.springcourse.HW13_Neil.Computer;
import ru.boraldan.springcourse.HW13_Neil.Music;
import ru.boraldan.springcourse.HW13_Neil.MusicPlayer;
import ru.boraldan.springcourse.HW13_Neil.genres.ClassicalMusic;
import ru.boraldan.springcourse.HW13_Neil.genres.JazzMusic;
import ru.boraldan.springcourse.HW13_Neil.genres.RockMusic;

import java.util.Arrays;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    @Scope("prototype")
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public JazzMusic jazzMusic() {
        return new JazzMusic();
    }

    @Bean
    public List<Music> musicList() {
        // Этот лист неизменяемый (immutable)
        return Arrays.asList(classicalMusic(), rockMusic(), jazzMusic());
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