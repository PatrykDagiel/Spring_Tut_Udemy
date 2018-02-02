package spring.tutorial.spring_udemy;

public class BaseballCoach implements Coach{
    //define private field for FS
    private FortuneService fortuneService;
    // define constructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        // use fortuneService
        return fortuneService.getFortune();
    }
}
