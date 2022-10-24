package be.abis.exercise.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimingAspect {

    @Around("be.abis.exercise.aspect.AOPPointCuts.executeFind()")       // "pointcut = " not eligible with @Around
    public Object timing(ProceedingJoinPoint pjp) throws Throwable {    // type in w/o "pointcut = "
        Object object = null;
        long start = System.nanoTime();
        object = pjp.proceed();
        long end = System.nanoTime();
        System.out.println("time taken by " + pjp.getSignature().getName() +" : " + ((end-start)/1000000.0) + " milliseconds");
        return object;
    }

}
