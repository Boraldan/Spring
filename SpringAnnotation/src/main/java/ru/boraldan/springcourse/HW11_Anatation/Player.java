package ru.boraldan.springcourse.HW11_Anatation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Player {

    @Value("${player.name}")
    public String name;


    @Autowired
    private Classic classic;
    @Autowired
    private Rock rock;

    public void playMusic(MyEnam myEnam) {
        Random r = new Random();
        int indexCl = r.nextInt(classic.getSong().size());
        int indexRo = r.nextInt(rock.getSong().size());

        if (myEnam == MyEnam.ROCK) {
            System.out.println(rock.getSong().get(indexRo));
        } else {
            System.out.println(classic.getSong().get(indexCl));
        }
    }
}
