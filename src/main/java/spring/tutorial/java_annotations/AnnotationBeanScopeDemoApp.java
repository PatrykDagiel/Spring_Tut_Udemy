package spring.tutorial.java_annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        //load spring config file

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_java.xml");

        // retrieve some bean from container

        Coach theCoach = context.getBean("swimCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
        boolean areEqual = (theCoach == alphaCoach);
        System.out.println("Sad fortune is " + theCoach.getDailyFortune());
        System.out.println("\nPointing to the same object: " + areEqual);
        System.out.println("\nMemory location for theCoach " + theCoach);
        System.out.println("\nMemory location for alphaCoach " + alphaCoach);

        context.close();
    }
}
