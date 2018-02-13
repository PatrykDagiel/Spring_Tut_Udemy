package spring.tutorial.java_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_java.xml");
        //get the bean from spring container
        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        //call a method on a bean
        System.out.println(theCoach.getDailyWorkout());
        //close the context
        context.close();
    }
}
