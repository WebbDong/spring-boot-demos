package com.webbdong.springboot.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class SqlPerformanceAspect {

    @Pointcut("execution(public * com.webbdong.springboot.aop.dao.mapper..*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object logPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        String name = "-";
        boolean success = true;
        try {
            name = joinPoint.getSignature().toShortString();
            return joinPoint.proceed();
        } catch (Throwable t) {
            success = false;
            throw t;
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("{};success:{};{}ms", name, success, endTime - startTime);
        }
    }

}
