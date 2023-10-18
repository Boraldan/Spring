package ru.boraldan.springcourse.Les13;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ru.boraldan.springcourse.Les13")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
//
//    @Bean
//    public ClassicalMusic classicalMusic(){
//        return new ClassicalMusic();
//    }
//
//    @Bean
//    public TranseVocal transeVocal(){
//        return new TranseVocal();
//    }
}
