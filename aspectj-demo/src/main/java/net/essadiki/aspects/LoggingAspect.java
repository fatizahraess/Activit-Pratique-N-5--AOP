
package net.essadiki.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* net.essadiki.services.MetierImpl.*(..))")
    public void metierMethods() {
    }

    @Before("metierMethods()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println(
                "[AspectJ - BEFORE] Avant l'execution de : "
                        + joinPoint.getSignature().getName()
        );
    }

    @After("metierMethods()")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println(
                "[AspectJ - AFTER] Apres l'execution de : "
                        + joinPoint.getSignature().getName()
        );
    }
}
