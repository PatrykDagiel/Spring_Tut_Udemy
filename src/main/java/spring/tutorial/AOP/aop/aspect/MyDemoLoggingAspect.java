package spring.tutorial.AOP.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import spring.tutorial.AOP.aop.demo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging
    // let's start with an @before advice
//    @Before("execution(* add*(spring.tutorial.AOP.aop.demo.Account, ..))")
    @Before("spring.tutorial.AOP.aop.aspect.AoPExpressions.forDoPackageNoGetterSetter())")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.printf("\n==========> Executing @Before advice on addAccount()");

        // MethodSignature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("\nMethod signature: \n" + methodSig);

        // display method arguments

        Object[] args = theJoinPoint.getArgs();
        for(Object temp : args) {
            System.out.println("\n The arguments are: " + temp);
            if (temp instanceof Account) {
                Account theAccount = (Account) temp;

                System.out.println("\n Account name is " + theAccount.getName());
                System.out.println("\n Account level is " + theAccount.getLevel());
            }
        }
    }

    @Before("spring.tutorial.AOP.aop.aspect.AoPExpressions.forSetters())")
    public void myCloudAspect() {
        System.out.println("\n======>>> Perform some cloud work -> SETTER");
    }

}
