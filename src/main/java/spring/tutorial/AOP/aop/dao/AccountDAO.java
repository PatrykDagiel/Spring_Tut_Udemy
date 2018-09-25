package spring.tutorial.AOP.aop.dao;

import org.springframework.stereotype.Component;
import spring.tutorial.AOP.aop.demo.Account;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " : doing my DB work: Adding and account");
    }

    public String getName() {
        System.out.println("Get name in " + getClass());
        return name;
    }

    public void setName(String name) {
        System.out.println("Set name in " + getClass());
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("Get service code in " + getClass());
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("Set service code in " + getClass());
        this.serviceCode = serviceCode;
    }
}


