package spring.tutorial.AOP.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging
    // let's start with an @before advice
//    @Before("execution(* add*(spring.tutorial.AOP.aop.demo.Account, ..))")
    @Before("spring.tutorial.AOP.aop.aspect.AoPExpressions.forDoPackageNoGetterSetter())")
    public void beforeAddAccountAdvice() {
        System.out.printf("\n==========> Executing @Before advice on addAccount()");
    }

    @Before("spring.tutorial.AOP.aop.aspect.AoPExpressions.forSetters())")
    public void myCloudAspect() {
        System.out.println("\n======>>> Perform some cloud work -> SETTER ");
    }

}
