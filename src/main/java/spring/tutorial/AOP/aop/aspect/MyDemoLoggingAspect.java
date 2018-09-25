package spring.tutorial.AOP.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // create pointcut for getter methods
    @Pointcut("execution(* spring.tutorial.AOP.aop.dao.*.get*(..))")
    private void forGetters() {
        System.out.println("=======>>>>>>>>This is a pointcut fo getters");
    }
    // create pointcut for setter methods
    @Pointcut("execution(* spring.tutorial.AOP.aop.dao.*.set*(..))")
    private void forSetters() {
        System.out.println("=======>>>>>>>>This is a pointcut fo setters");
    }

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDoPackage() && !(forGetters() || forSetters())")
    private void forDoPackageNoGetterSetter() {
        System.out.println("=====>Not for getter nor setter");
    }

    @Pointcut("execution(* spring.tutorial.AOP.aop.dao.*.*(..))" )
    private void forDoPackage() {}

    // this is where we add all of our related advices for logging

    // let's start with an @before advice
//    @Before("execution(* add*(spring.tutorial.AOP.aop.demo.Account, ..))")
    @Before("forDoPackageNoGetterSetter())")
    public void beforeAddAccountAdvice() {
        System.out.printf("\n==========> Executing @Before advice on addAccount()");
    }

    @Before("forDoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n======>>> Perform API analytics");
    }

    @Before("forSetters())")
    public void myCloudAspect() {
        System.out.println("\n======>>> Perform some cloud work -> SETTER");
    }

}
