package com.webbdong.springboot.aop.aspect;

import com.webbdong.springboot.aop.annotation.MyAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author WebbDong
 * @createTime 2023-05-31 23:08
 */
@Component
@Aspect
public class AnnotationControllerAspect {

    @Around("execution(public * com.webbdong.springboot.aop.controller..*.*(..)) && @annotation(com.webbdong.springboot.aop.annotation.MyAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());
        MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
        if (myAnnotation != null) {
            System.out.println(myAnnotation.param1());
        }
        return joinPoint.proceed();
    }

}
