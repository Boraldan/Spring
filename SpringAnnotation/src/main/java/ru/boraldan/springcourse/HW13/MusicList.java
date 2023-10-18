package ru.boraldan.springcourse.HW13;

import ru.boraldan.springcourse.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicList {

    private List<Music> music = new ArrayList<>();

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music.add(music);
    }
}
