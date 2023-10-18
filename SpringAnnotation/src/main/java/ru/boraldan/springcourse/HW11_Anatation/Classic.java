package ru.boraldan.springcourse.HW11_Anatation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Classic implements IMusic {
    private List<String> classicList = new ArrayList<>(Arrays.asList("c1", "c2", "c3"));

    @Override
    public List<String> getSong() {
        return classicList;
    }
}
