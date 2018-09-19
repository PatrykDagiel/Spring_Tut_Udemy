package spring.tutorial.AOP.aop.dao;


public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + " : doing my DB work: Adding and account");
    }

}
