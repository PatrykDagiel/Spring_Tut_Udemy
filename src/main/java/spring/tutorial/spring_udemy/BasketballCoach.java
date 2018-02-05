package spring.tutorial.spring_udemy;

public class BasketballCoach implements Coach {

    private FortuneService fortuneService;

    private String emailAddress;
    private String team;

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


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("This is basketball Email setter method");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("This is basketball Team setter method");
        this.team = team;
    }
}

