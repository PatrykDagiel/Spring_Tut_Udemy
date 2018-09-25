package spring.tutorial.AOP.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* spring.tutorial.AOP.aop.dao.*.*(..))")
    private void forDoPackage() {}

    // this is where we add all of our related advices for logging

    // let's start with an @before advice
//    @Before("execution(* add*(spring.tutorial.AOP.aop.demo.Account, ..))")
    @Before("forDoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.printf("\n==========> Executing @Before advice on addAccount()");
    }

    @Before("forDoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n======>>> Perform API analytics");
    }

}
