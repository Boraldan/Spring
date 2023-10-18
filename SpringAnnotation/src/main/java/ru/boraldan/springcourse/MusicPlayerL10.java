package ru.boraldan.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayerL10 {

    @Autowired
    @Qualifier("classicalMusic")
    private Music musicC;
    @Autowired
    @Qualifier("transeVocal")
    private Music musicR;



    // Les 10  ------------------------
//    @Autowired
//    private Music music;

//    private TranseVocal transeVocal;
//
//    @Autowired
//    public MusicPlayerL10(TranseVocal transeVocal) {
//        this.transeVocal = transeVocal;
//    }

//    public void playMusic() {
//        System.out.println("Playing  " + transeVocal.getSong());
//    }
    // -------------------------------
public void playMusic() {
    System.out.println("Playing  " + musicC.getSong());
}

}
