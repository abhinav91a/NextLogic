package com.nextlogic.jobservice.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.nextlogic.jobservice.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("➡️ Entering: {}", joinPoint.getSignature());
    }

    @AfterReturning(
            pointcut = "execution(* com.nextlogic.jobservice.service.*.*(..))",
            returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        log.info("⬅️ Exiting: {} | Return: {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.nextlogic.jobservice.service.*.*(..))",
            throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.error("❌ Exception in {} | Message: {}", joinPoint.getSignature(), ex.getMessage());
    }
}
