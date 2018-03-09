package spring.tutorial.java_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring.tutorial.java_annotations")
public class SportConfig {

    @Bean
    public Coach swimCoach(FortuneService fortuneService) {
        SwimCoach mySwimCoach = new SwimCoach(happyFortuneService());
        return mySwimCoach;
    }

    @Bean
    public FortuneService happyFortuneService() {
        return new HappyFortuneService();
    }

}
