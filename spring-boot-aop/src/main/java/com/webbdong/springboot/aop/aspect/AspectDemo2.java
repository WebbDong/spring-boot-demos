package com.webbdong.springboot.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Webb Dong
 * @date 2021-04-16 2:01 PM
 */
@Aspect
@Component
@Slf4j
public class AspectDemo2 {

    @Around("PointcutDef.pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AspectDemo2.around() start");
        log.info("AspectDemo2.around() joinPoint.getTarget().getClass().getName() = {}",
                joinPoint.getTarget().getClass().getName());
        Object[] args = joinPoint.getArgs();
        log.info("AspectDemo2.around() Args: {}", Arrays.toString(args));
        log.info("AspectDemo2.around() joinPoint.getThis().getClass().getName() = {}",
                joinPoint.getThis().getClass().getName());
        log.info("AspectDemo2.around() joinPoint.getKind() = {}", joinPoint.getKind());
        log.info("AspectDemo2.around() joinPoint.getSignature() = {}", joinPoint.getSignature());
        Object ret = joinPoint.proceed();
        log.info("AspectDemo2.around() end");
        return ret;
    }

}
