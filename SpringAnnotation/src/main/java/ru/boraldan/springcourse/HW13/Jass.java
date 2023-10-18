package ru.boraldan.springcourse.HW13;

import org.springframework.stereotype.Component;
import ru.boraldan.springcourse.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Jass implements Music {

    private List<String> jassList = new ArrayList<>(Arrays.asList("j1", "j2", "j3"));

    public List<String> getJass() {
        return jassList;
    }

    @Override
    public String getSong() {
        return "Playing Jass";
    }
}
