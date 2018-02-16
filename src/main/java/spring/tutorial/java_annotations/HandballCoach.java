package spring.tutorial.java_annotations;

import org.springframework.stereotype.Component;

@Component
public class HandballCoach implements Coach {

    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "Running 10 laps";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
