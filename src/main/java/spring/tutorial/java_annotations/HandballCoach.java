package spring.tutorial.java_annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HandballCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Running 10 laps with team:" + team;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
