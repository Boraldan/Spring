package ru.boraldan.springcourse.HW13_Neil.genres;

import ru.boraldan.springcourse.HW13_Neil.Music;

/**
 * @author Neil Alishev
 */
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
