package ru.boraldan.springcourse.HW13;

import org.springframework.stereotype.Component;
import ru.boraldan.springcourse.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ClassicalMusic implements Music {

    private List<String> classicList = new ArrayList<>(Arrays.asList("c1", "c2", "c3"));

    public List<String> getClassicList() {
        return classicList;
    }

    @Override
    public String getSong() {
        Random r = new Random();
        return "Vivaldi " + classicList.get(r.nextInt(classicList.size()));
//        return "Vivaldi  " + classicList.get(0);
    }
}
