package ru.boraldan.springcourse;

import org.springframework.stereotype.Component;

@Component
public class TranseVocal implements Music{


    @Override
    public String getSong() {
        return "TransVocal";
    }
}
