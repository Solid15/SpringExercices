package be.abis.exercise.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AOPPointCuts {

    @Pointcut("execution(* be.abis.exercise.service.*.enroll*(..))")        // public optional
    public void executeEnroll() { }

    @Pointcut("execution(* be.abis.exercise.service.*.find*(..))")
    public void executeFind() { }


}
