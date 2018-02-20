package spring.tutorial.java_annotations;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    @Autowired
    @Qualifier("myOwnFortuneService")
    FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(FortuneService theFortuneService) {
//        fortuneService = theFortuneService;
//    }

    public TennisCoach() {
        System.out.println("Inside default constructor");
    }

    @Override
    public String getDailyWorkout() {

        return "Practice your backhand volley with team: " + team;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
