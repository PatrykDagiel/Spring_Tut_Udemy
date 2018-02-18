package spring.tutorial.java_annotations;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {
    @Override
    public String getFortune() {
        return null;
    }

}
