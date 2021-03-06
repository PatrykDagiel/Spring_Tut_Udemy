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
        Account theAccount = new Account();
        theAccount.setLevel("Test_1");
        theAccount.setName("TestName");
        // call business method
        theAccountDAO.addAccount(theAccount, true);
        theAccountDAO.addAccount(theAccount, false);

        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        System.out.printf("Membership DAO \n");
        membershipDAO.addAccount();

        // close the context
        context.close();
    }
}
