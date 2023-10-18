package ru.boraldan.springcourse.Les13;

import org.springframework.stereotype.Component;
import ru.boraldan.springcourse.Music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ClassicalMusic implements Music {

    private List<String> classicList = new ArrayList<>(Arrays.asList("c1", "c2", "c3"));

    @Override
    public String getSong() {
        return "Vivaldi";
    }
}
