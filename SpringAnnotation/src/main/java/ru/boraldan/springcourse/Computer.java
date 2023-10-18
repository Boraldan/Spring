package ru.boraldan.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    @Autowired
    private MusicPlayerL10 musicPlayerL10;

    public void startPlayer(){
        musicPlayerL10.playMusic();
    }
}
