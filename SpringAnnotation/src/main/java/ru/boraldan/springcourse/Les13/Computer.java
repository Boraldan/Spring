package ru.boraldan.springcourse.Les13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.boraldan.springcourse.MusicPlayerL10;

@Component
public class Computer {
    @Autowired
    private MusicPlayer musicPlayer;

    public void startPlayer(){
        musicPlayer.playMusicList();
    }
}
