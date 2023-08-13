package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.services.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* org.example.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {


        //Get the method name
        String methodName = joinPoint.getSignature().getName();
        Object[] param = joinPoint.getArgs();
        Comment aspectComment = new Comment();
        aspectComment.setText("Comment from Logging Aspect");
        aspectComment.setAuthor("Daemon");
        Object[] newArgs = {aspectComment};

        logger.info("Method " + methodName + " with parameters " + Arrays.asList(param) + " will execute.");

        /*Sends a new parameter to the method*/
        Object returnedValue = joinPoint.proceed(newArgs);
        logger.info("Method " + joinPoint.getSignature().getName() + "() completed execution and returned " + returnedValue + ".");

        return "FAILED";
    }

}
