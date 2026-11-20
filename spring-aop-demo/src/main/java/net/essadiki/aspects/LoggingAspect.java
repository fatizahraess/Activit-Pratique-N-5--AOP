
package net.essadiki.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* net.essadiki.services.MetierImpl.*(..))")
    public void metierMethods() {
    }

    @Before("metierMethods()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println(
                "[Spring AOP - BEFORE] Avant : "
                        + joinPoint.getSignature().getName()
        );
    }

    @After("metierMethods()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println(
                "[Spring AOP - AFTER] Apres : "
                        + joinPoint.getSignature().getName()
        );
    }
}
