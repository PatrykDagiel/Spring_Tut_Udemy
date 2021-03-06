package spring.tutorial.AOP.aop.dao;

import org.omg.SendingContext.RunTime;
import org.springframework.stereotype.Component;
import spring.tutorial.AOP.aop.demo.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " : doing my DB work: Adding and account");
    }

    // add a new method: findAccounts()
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire) {
            throw new RuntimeException("EXCEPTION FROM FIND ACCOUNTS");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account tempAcc1 = new Account("Temp_1", "Gold");
        Account tempAcc2 = new Account("Temp_2", "Platinum");
        Account tempAcc3 = new Account("Temp_3", "Gold");

        // add them to list
        myAccounts.add(tempAcc1);
        myAccounts.add(tempAcc2);
        myAccounts.add(tempAcc3);

        return myAccounts;
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


