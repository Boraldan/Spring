package ru.boraldan.springcourse.HW13_Neil.genres;

import ru.boraldan.springcourse.HW13_Neil.Music;



/**
 * @author Neil Alishev
 */
public class ClassicalMusic implements Music {

    public void doMyInit() {
        System.out.println("Doing my initialization");
    }

    // Для Prototype бинов не вызывается destroy-метод!

    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }

    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
