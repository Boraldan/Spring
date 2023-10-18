package ru.boraldan.springcourse.HW13;

import ru.boraldan.springcourse.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Rock implements Music {

    private List<String> rockList = new ArrayList<>(Arrays.asList("r1", "r2", "r3"));

    public List<String> getRockList() {
        return rockList;
    }



    @Override
    public String getSong() {
        Random r = new Random();
        return "Rock " + rockList.get(r.nextInt(rockList.size()));
    }
}
