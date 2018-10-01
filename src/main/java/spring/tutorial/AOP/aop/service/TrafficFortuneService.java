package spring.tutorial.AOP.aop.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() throws InterruptedException {

        // simulate a delay
        TimeUnit.SECONDS.sleep(5);
        // return a fortune

        // return a fortune
        return "Expect heavy traffic.";
    }

}
