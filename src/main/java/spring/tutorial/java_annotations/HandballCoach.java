package spring.tutorial.java_annotations;

import org.springframework.stereotype.Component;

@Component
public class HandballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Running 10 laps";
    }
}
