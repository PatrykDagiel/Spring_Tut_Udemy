package spring.tutorial.AOP.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.tutorial.AOP.aop.dao.AccountDAO;
import spring.tutorial.AOP.aop.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        // call business method
        theAccountDAO.addAccount();
        theAccountDAO.addAccount();

        System.out.printf("Membership DAO \n");
        membershipDAO.addAccount();

        // close the context
        context.close();
    }
}
