
package net.essadiki.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PerformanceAspect {

    @Around("execution(* net.essadiki.services.MetierImpl.*(..))")
    public Object measureExecutionTime(
            ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime();

        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.nanoTime();

            double duration =
                    (endTime - startTime) / 1_000_000.0;

            System.out.println(
                    "[AspectJ - AROUND] Methode : "
                            + joinPoint.getSignature().getName()
                            + " | Duree : " + duration + " ms"
            );
        }
    }
}
