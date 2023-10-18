package ru.boraldan.springcourse;

public class ClassicalMusic  implements Music{

    private static int count;

    public void doMyInit(){
        count++;
        System.out.println("Start init... " + count);
    }
    public void doMyDestroy(){
        System.out.println("Close bean.");
    }
    @Override
    public String getSong() {
        return "Vivaldi";
    }
}
