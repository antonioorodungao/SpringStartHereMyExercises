package org.examples.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class SecurityAspect {

    private static final Logger logger = LoggerFactory.getLogger(SecurityAspect.class);
    @Around(value="@annotation(org.examples.annotations.ToLog)")
    public void Log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Security Log aspect before calling the method.");
        joinPoint.proceed();

    }
}
