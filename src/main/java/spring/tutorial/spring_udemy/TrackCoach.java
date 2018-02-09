package spring.tutorial.spring_udemy;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public TrackCoach() {

    }

    // add an init method
    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    // add a destroy method
    public void doMyCleanupStuffYoYo() {
        System.out.println("TrackCoach: inside method doMyCleanup");
    }

    @Override
    public String getDailyWorkout()
    {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Tracky " + fortuneService.getFortune();
    }
}
