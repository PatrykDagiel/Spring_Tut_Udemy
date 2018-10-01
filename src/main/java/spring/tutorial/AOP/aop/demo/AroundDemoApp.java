package spring.tutorial.AOP.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.tutorial.AOP.aop.dao.AccountDAO;
import spring.tutorial.AOP.aop.service.TrafficFortuneService;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // get the bean from spring container
        TrafficFortuneService trafficService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain program: Around Demo App");
        System.out.println("Calling getFortune");

        try {
            System.out.println(trafficService.getFortune());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // close the context
        context.close();
    }
}
