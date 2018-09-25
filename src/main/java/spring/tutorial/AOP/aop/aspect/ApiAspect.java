package spring.tutorial.AOP.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAspect {

    @Before("spring.tutorial.AOP.aop.aspect.AoPExpressions.forDoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n======>>> Perform API analytics");
    }

}
