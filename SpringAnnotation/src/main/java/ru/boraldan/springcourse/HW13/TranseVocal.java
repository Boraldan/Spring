package ru.boraldan.springcourse.HW13;

import org.springframework.stereotype.Component;
import ru.boraldan.springcourse.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class TranseVocal implements Music {

    private List<String> transList = new ArrayList<>(Arrays.asList("t1", "t2", "t3"));


    @Override
    public String getSong() {
        Random r = new Random();
//        return "TransVocal  " + transList.get(1);
        return "TransVocal " + transList.get(r.nextInt( transList.size()));

    }
}
