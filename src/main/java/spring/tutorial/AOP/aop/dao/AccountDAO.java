package spring.tutorial.AOP.aop.dao;

import org.springframework.stereotype.Component;
import spring.tutorial.AOP.aop.demo.Account;

@Component
public class AccountDAO {

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " : doing my DB work: Adding and account");
    }
}


