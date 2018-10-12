package spring.tutorial.AOP.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.tutorial.AOP.aop.service.TrafficFortuneService;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    
    private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
    
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // get the bean from spring container
        TrafficFortuneService trafficService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain program: Around Demo App");
        myLogger.info("Calling getFortune");

        boolean tripWire = true;
        String data = null;
        try {
            data = trafficService.getFortune(tripWire);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            myLogger.info(data);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        // close the context
        context.close();
    }
}
