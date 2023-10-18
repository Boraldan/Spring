package ru.boraldan.springcourse.HW13;

import org.springframework.beans.factory.annotation.Value;
import ru.boraldan.springcourse.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    private MusicList musicList;

//    private List<Music> musicList = new ArrayList<>();

//    public MusicPlayer(Music mus1, Music mus2, Music mus3) {
//        this.musicList.add(mus1);
//        this.musicList.add(mus2);
//        this.musicList.add(mus3);
//    }


    public MusicPlayer(MusicList musicList) {
        this.musicList = musicList;
    }

    public void playMusicList() {
        Random r = new Random();
        for (Music mus : musicList.getMusic()) {
            System.out.println(mus.getSong() + ". Громкость: " + volume + "  " + name);
        }
    }
}
