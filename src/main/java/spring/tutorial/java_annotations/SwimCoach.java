package spring.tutorial.java_annotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    @Override
    public String getDailyWorkout() {
        return "Swim 1000m as a warmup";
    }

    public void showMeTheMoney() {
        System.out.println("Email is" + this.email + " and team is " + this.email);
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }


}
