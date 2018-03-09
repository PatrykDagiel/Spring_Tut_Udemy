package spring.tutorial.java_annotations;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000m as a warmup";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
