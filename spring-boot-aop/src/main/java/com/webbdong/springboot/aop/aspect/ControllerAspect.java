package com.webbdong.springboot.aop.aspect;

import com.webbdong.springboot.aop.model.request.CommonRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Webb Dong
 * @date 2022-02-26 10:17 PM
 */
@Component
@Aspect
public class ControllerAspect {

    @Around("execution(public * com.webbdong.springboot.aop.controller..*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        CommonRequest request = (CommonRequest) args[0];
        request.setUserID(1000L);
        return joinPoint.proceed();
    }

}
