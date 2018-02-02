package spring.tutorial.spring_udemy;

public class BasketballCoach implements Coach {

    private FortuneService fortuneService;

    public BasketballCoach() {
        System.out.println("Basketball Coach default (no-arg) constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Made 100 3-pointers";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("This is basketball Fortune setter method");
        this.fortuneService = fortuneService;
    }


}

