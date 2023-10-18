package ru.boraldan.springcourse.HW13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {

    private MusicPlayer musicPlayer;

    public Computer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public void startPlayer(){
        musicPlayer.playMusicList();
    }
}
