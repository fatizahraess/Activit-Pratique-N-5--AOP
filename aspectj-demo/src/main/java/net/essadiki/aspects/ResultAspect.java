
package net.essadiki.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ResultAspect {

    @AfterReturning(
            pointcut = "execution(double net.essadiki.services.MetierImpl.compute(..))",
            returning = "result"
    )
    public void afterReturning(
            JoinPoint joinPoint, Object result) {

        System.out.println(
                "[AspectJ - AFTER RETURNING] Methode : "
                        + joinPoint.getSignature().getName()
                        + " | Resultat : " + result
        );
    }

    @AfterThrowing(
            pointcut = "execution(* net.essadiki.services.MetierImpl.*(..))",
            throwing = "exception"
    )
    public void afterThrowing(
            JoinPoint joinPoint, Throwable exception) {

        System.out.println(
                "[AspectJ - AFTER THROWING] Methode : "
                        + joinPoint.getSignature().getName()
                        + " | Erreur : " + exception.getMessage()
        );
    }
}
