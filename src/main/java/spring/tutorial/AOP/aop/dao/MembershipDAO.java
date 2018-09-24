package spring.tutorial.AOP.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addAccount() {
        System.out.println(getClass() + ": DOING STUFF: Adding a membership account");
        return false;
    }
}
