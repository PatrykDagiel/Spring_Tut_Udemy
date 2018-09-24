package spring.tutorial.AOP.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    // let's start with an @before advice
//    @Before("execution(* add*(spring.tutorial.AOP.aop.demo.Account, ..))")
    @Before("execution(* spring.tutorial.AOP.aop.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.printf("\n==========> Executing @Before advice on addAccount()");
    }
}
