package spring.tutorial.spring_udemy;

public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout()
    {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Tracky";
    }
}
