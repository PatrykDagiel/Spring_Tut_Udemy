package spring.tutorial.AOP.aop.demo;

import org.aspectj.lang.annotation.Around;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.tutorial.AOP.aop.dao.AccountDAO;
import spring.tutorial.AOP.aop.service.TrafficFortuneService;

import java.util.List;
import java.util.logging.Logger;

public class AroundDemoApp {
    
    private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());
    
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // get the bean from spring container
        TrafficFortuneService trafficService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain program: Around Demo App");
        myLogger.info("Calling getFortune");

        try {
            myLogger.info(trafficService.getFortune());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // close the context
        context.close();
    }
}
