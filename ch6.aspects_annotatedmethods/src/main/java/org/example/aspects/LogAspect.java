package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(org.example.annotations.ToLog)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Aspect is executed using @Around with custom @ToLog PointCut");
        joinPoint.proceed();
    }


    @Before("@annotation(org.example.annotations.InterceptBefore)")
    public void logAspectAnnotationBefore() {
        logger.info("Aspect before the method execution");

    }

    @After("@annotation(org.example.annotations.InterceptAfter))")
    public void logAspectAnnotationAfter() {
        logger.info("Aspect after method execution.");
    }

    @AfterReturning("@annotation(org.example.annotations.InterceptAfterReturning)")
    public void logAspectAnnotationAfterReturning() {
        logger.info("Aspect after method returns.");
    }

    @AfterThrowing("@annotation(org.example.annotations.InterceptOnThrow)")
    public void logAspectAnnotationOnThrow() {
        logger.info("Aspect after an exception is thrown.");
    }


}
