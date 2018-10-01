package spring.tutorial.AOP.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.tutorial.AOP.aop.dao.AccountDAO;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find accounts
        try {
            boolean tripWire = true;
            List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n Exception handled by MAIN APP");
            e.printStackTrace();
        }
        // Display the accounts
        System.out.println("\n Main program: AfterReturnDemoApp");
        System.out.println("---------------");

        // close the context
        context.close();
    }
}
