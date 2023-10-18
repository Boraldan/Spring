package ru.boraldan.springcourse;

public class ClassicalMusicL8Factory implements Music {

    private ClassicalMusicL8Factory() {
    }

    public static ClassicalMusicL8Factory getClassikalMusicL8Fact(){
        return new ClassicalMusicL8Factory();
    }

    public void doMyInit(){
        System.out.println("Start init... " );
    }
    public void doMyDestroy(){
        System.out.println("Close bean.");
    }
    @Override
    public String getSong() {
        return "Vivaldi";
    }
}
