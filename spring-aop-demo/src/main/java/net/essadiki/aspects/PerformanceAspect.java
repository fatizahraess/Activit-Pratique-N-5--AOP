
package net.essadiki.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* net.essadiki.services.MetierImpl.*(..))")
    public Object measureExecutionTime(
            ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.nanoTime();

        try {
            return joinPoint.proceed();
        } finally {
            long end = System.nanoTime();
            double duration = (end - start) / 1_000_000.0;

            System.out.println(
                    "[Spring AOP - AROUND] "
                            + joinPoint.getSignature().getName()
                            + " | Duree : " + duration + " ms"
            );
        }
    }
}
