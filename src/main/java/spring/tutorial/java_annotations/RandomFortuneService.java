package spring.tutorial.java_annotations;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Xyz";
    }

}
