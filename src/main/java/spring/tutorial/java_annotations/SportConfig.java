package spring.tutorial.java_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("spring.tutorial.java_annotations")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public Coach swimCoach() {
        SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
        return mySwimCoach;
    }

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

}
