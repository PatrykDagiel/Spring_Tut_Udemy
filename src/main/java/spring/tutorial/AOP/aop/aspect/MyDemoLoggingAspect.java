package spring.tutorial.AOP.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import spring.tutorial.AOP.aop.demo.Account;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());
    
    @Around("execution(* spring.tutorial.AOP.aop.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n====>>>>>>> Execution @ around on method: " + method);

        // get begin/end timestamp
        long begin = System.currentTimeMillis();

        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            myLogger.info("We have warning: " + e.getMessage());

            result = "Major accident, your helicopter is on the way!";
        }

        long end = System.currentTimeMillis();

        // now, let's execute the method
        long duration = end - begin;

        // compute duration and display it
        myLogger.info("\n------->>Duration is: " + duration/1000.0 + " seconds");

        return result;
    }


    @After("execution(* spring.tutorial.AOP.aop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n Executing : ------> " + method);
        myLogger.info("\n After advice has been applied");
    }

    @AfterThrowing(value = "execution(* spring.tutorial.AOP.aop.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\nMethod is _______: " + method);
        myLogger.info("\n====XX=> The exception is:" + theExc);
    }

    @AfterReturning(pointcut = "execution(* spring.tutorial.AOP.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("\n======>>> Executing afterReturning on method: " + method);

        myLogger.info("\n ======>>>> result is: " + result);

        // Lets post process the data

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        myLogger.info("\n ======>>>> result uppercased is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account x : result) {
            String name = x.getName().toUpperCase();
            x.setName(name);
        }
    }


    // this is where we add all of our related advices for logging
    // let's start with an @before advice
//    @Before("execution(* add*(spring.tutorial.AOP.aop.demo.Account, ..))")
    @Before("spring.tutorial.AOP.aop.aspect.AoPExpressions.forDoPackageNoGetterSetter())")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.printf("\n==========> Executing @Before advice on addAccount()");

        // MethodSignature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("\nMethod signature: \n" + methodSig);

        // display method arguments

        Object[] args = theJoinPoint.getArgs();
        for(Object temp : args) {
            myLogger.info("\n The arguments are: " + temp.toString());
            if (temp instanceof Account) {
                Account theAccount = (Account) temp;

                myLogger.info("\n Account name is " + theAccount.getName());
                myLogger.info("\n Account level is " + theAccount.getLevel());
            }
        }
    }

    @Before("spring.tutorial.AOP.aop.aspect.AoPExpressions.forSetters())")
    public void myCloudAspect() {
        myLogger.info("\n======>>> Perform some cloud work -> SETTER");
    }

}
