package spring.tutorial.java_annotations;

public class CoachPA7 implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice Activity 7 workout";
    }

    @Override
    public String getDailyFortune() {
        return "Practice activity 7 fortune";
    }

    private FortuneService fortuneServicePA7;

    public CoachPA7(FortuneService theFortuneService) {
        this.fortuneServicePA7 = theFortuneService;
    }

}
