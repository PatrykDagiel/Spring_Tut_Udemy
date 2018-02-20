package spring.tutorial.java_annotations;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    // create an array of Strings
    private String[] data = {
        "This is the strign number 1",
        "This is the string number 2",
        "This is the string number 3"
    };

    private Random random = new Random();

    @Override
    public String getFortune() {
        // pick random string from the array
        int index = random.nextInt(data.length);
        String theFortune = data[index];
        return theFortune;
    }

}
