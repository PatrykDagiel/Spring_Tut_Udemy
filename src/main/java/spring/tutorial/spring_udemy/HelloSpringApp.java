package spring.tutorial.spring_udemy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean from spring container
        BasketballCoach theCoach = context.getBean("myCoachBasket", BasketballCoach.class);
        BasketballCoach theCoach2 = context.getBean("myCoachBasket", BasketballCoach.class);
        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        System.out.println(theCoach2.getDailyFortune());
        System.out.println(theCoach2.getDailyWorkout());
        System.out.println(theCoach2.getEmailAddress());
        System.out.println(theCoach2.getTeam());

        System.out.println("Memory location for 1st Coach: " + theCoach);
        System.out.println("Memory location for 2nd Coach: " + theCoach2);

        // close the context
        context.close();
    }

}
