package spring.tutorial.spring_udemy;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

    private Random random = new Random();

    private String[] data = {"AAAA", "BBBB", "CCCC"};

    @Override
    public String getFortune() {
        int index = random.nextInt(data.length);
        return data[index];
    }
}
