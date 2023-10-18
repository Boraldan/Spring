package ru.boraldan.springcourse.HW11_Anatation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Rock implements IMusic {


    public void doMyInit(){
        System.out.println("Init...");
    }


    private List<String> rockList = new ArrayList<>(Arrays.asList("R1", "r2", "r3"));

    @Override
    public List<String> getSong() {
        return rockList;
    }


}
