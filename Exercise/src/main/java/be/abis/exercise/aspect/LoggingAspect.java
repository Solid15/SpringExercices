package be.abis.exercise.aspect;

import be.abis.exercise.exceptions.EnrollException;
import be.abis.exercise.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect                                                 // Aspect -> write into maven as a dependency
public class LoggingAspect {

    Logger exceptionLogger = LogManager.getLogger("exceptionLogger");
    Logger infoLogger = LogManager.getRootLogger();      // rootLogger configured to log to console in xml


    // pointcut = "PointCuts.executeEnroll()" not required, AOP path may be directly written in ()
    @Before("execution(public * be.abis.exercise.service.*.enrollForSession(..))")       // public optional
    public void beforeEnrolling() {
        infoLogger.info("Student enrollment method called");
    }

    @AfterReturning(pointcut = "be.abis.exercise.aspect.AOPPointCuts.executeEnroll()")
    public void enrollmentSuccess(JoinPoint joinPoint) {    // After method has been completed successfully w/o exceptions (void return accepted)
       String name = ((Person) joinPoint.getArgs()[0]).getFirstName();
       infoLogger.info(name + ": Enrollment has been completed successfully");
    }
                            // pointcut optional, but required with multiple arguments
    @AfterThrowing(pointcut = "be.abis.exercise.aspect.AOPPointCuts.executeEnroll()", throwing = "e")
    public void afterWrongDateEnrollment(EnrollException e) {
        exceptionLogger.error("Wrong enrollment date chosen: " + e.getMessage());
    }

                            /// No Spring MVC, we'll use ANGULAR
}
