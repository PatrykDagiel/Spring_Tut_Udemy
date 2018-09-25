package spring.tutorial.AOP.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AoPExpressions {
    // create pointcut for getter methods
    @Pointcut("execution(* spring.tutorial.AOP.aop.dao.*.get*(..))")
    public void forGetters() {
        System.out.println("=======>>>>>>>>This is a pointcut fo getters");
    }
    // create pointcut for setter methods
    @Pointcut("execution(* spring.tutorial.AOP.aop.dao.*.set*(..))")
    public void forSetters() {
        System.out.println("=======>>>>>>>>This is a pointcut fo setters");
    }

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDoPackage() && !(forGetters() || forSetters())")
    public void forDoPackageNoGetterSetter() {
        System.out.println("=====>Not for getter nor setter");
    }

    @Pointcut("execution(* spring.tutorial.AOP.aop.dao.*.*(..))" )
    public void forDoPackage() {}
}
