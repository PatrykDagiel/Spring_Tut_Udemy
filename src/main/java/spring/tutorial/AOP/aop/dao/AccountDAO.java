package spring.tutorial.AOP.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + " : doing my DB work: Adding and account");
    }

}
