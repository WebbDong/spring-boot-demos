package com.webbdong.springboot.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * AOP示例
 */
@Aspect
@Component
@Slf4j
public class AspectDemo {

    /**
     * 切点
     * execution格式：execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
     * 括号中各个pattern分别表示：
     *      修饰符匹配（modifier-pattern?）
     *      返回值匹配（ret-type-pattern）可以为*表示任何返回值,全路径的类名等
     *      类路径匹配（declaring-type-pattern?）
     *      方法名匹配（name-pattern）可以指定方法名 或者 *代表所有, set* 代表以set开头的所有方法
     *      参数匹配（(param-pattern)）可以指定具体的参数类型，多个参数间用“,”隔开，各个参数也可以用“*”来表示匹配任意类型的参数，如(String)表示匹配一个String参数的方法；(*,String) 表示匹配有两个参数的方法，第一个参数可以是任意类型，而第二个参数是String类型；可以用(..)表示零个或多个任意参数
     *      异常类型匹配（throws-pattern?）
     *      其中后面跟着“?”的是可选项
     * 例子：
     *      execution(* *(..))   表示匹配所有方法
     *      execution(public * com. savage.service.UserService.*(..))   表示匹配com.savage.server.UserService中所有的公有方法
     *      execution(* com.savage.server..*.*(..))   表示匹配com.savage.server包及其子包下的所有方法
     */
    @Pointcut("execution(public * com.webbdong.springboot.aop.service.AspectDemoService.*(..))")
    public void pointcut() {
    }

    /**
     * 前置通知
     */
    @Before("pointcut()")
    public void beforeAdvice1() {
        log.info("AspectDemo.beforeAdvice1()");
    }

    @Before("pointcut()")
    public void beforeAdvice2() {
        log.info("AspectDemo.beforeAdvice2()");
    }

    /**
     * 后置通知
     */
    @After("pointcut()")
    public void afterAdvice1() {
        log.info("AspectDemo.afterAdvice1()");
    }

    @After("pointcut()")
    public void afterAdvice2() {
        log.info("AspectDemo.afterAdvice2()");
    }

    /**
     * 后置返回通知
     */
    @AfterReturning("pointcut()")
    public void afterReturning1() {
        log.info("AspectDemo.afterReturning1()");
    }

    @AfterReturning("pointcut()")
    public void afterReturning2() {
        log.info("AspectDemo.afterReturning2()");
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("pointcut()")
    public void afterThrowing1() {
        log.info("AspectDemo.afterThrowing1()");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing2() {
        log.info("AspectDemo.afterThrowing2()");
    }

    /**
     * 环绕通知
     */
    @Around("pointcut()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AspectDemo.around1() start");
        log.info("AspectDemo.around1() joinPoint.getTarget().getClass().getName() = {}",
                joinPoint.getTarget().getClass().getName());
        // 获取目标方法的参数
        Object[] args = joinPoint.getArgs();
        log.info("AspectDemo.around1() Args: {}", Arrays.toString(args));
        // 代理对象
        log.info("AspectDemo.around1() joinPoint.getThis().getClass().getName() = {}",
                joinPoint.getThis().getClass().getName());
        log.info("AspectDemo.around1() joinPoint.getKind() = {}", joinPoint.getKind());
        log.info("AspectDemo.around1() joinPoint.getSignature() = {}", joinPoint.getSignature());

        // 如果不调用joinPoint.proceed()，那只会执行around()，其他方法全部都不会执行
        Object ret = joinPoint.proceed();
//        joinPoint.proceed();

        // 重新给目标方法传递实参
//        Object ret = joinPoint.proceed(new Object[] {640, "Lamborghini"});
//        Object ret = joinPoint.proceed(new Object[] {});
        log.info("AspectDemo.around1() end");
        return ret;
//        return null;
    }

    @Around("pointcut()")
    public Object around2(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("AspectDemo.around2() start");
        log.info("AspectDemo.around2() Args: {}", Arrays.toString(joinPoint.getArgs()));
        log.info("AspectDemo.around2() joinPoint.getTarget().getClass().getName() = {}",
                joinPoint.getTarget().getClass().getName());
        log.info("AspectDemo.around2() joinPoint.getThis().getClass().getName() = {}",
                joinPoint.getThis().getClass().getName());
        Object ret = joinPoint.proceed();
//        Object ret = joinPoint.proceed(new Object[] {((int) joinPoint.getArgs()[0]) + 360, "Ferrari"});
        log.info("AspectDemo.around2() end");
        return ret;
//        return null;
//        return -1;
    }

    /*
    @Around("pointcut()")
    public Object around2() throws Throwable {
        log.info("AspectDemo.around2() start");
//        log.info("AspectDemo.around2() Args: {}", Arrays.toString(joinPoint.getArgs()));
//        log.info("AspectDemo.around2() joinPoint.getTarget().getClass().getName() = {}",
//                joinPoint.getTarget().getClass().getName());
//        log.info("AspectDemo.around2() joinPoint.getThis().getClass().getName() = {}",
//                joinPoint.getThis().getClass().getName());
//        Object ret = joinPoint.proceed();
//        Object ret = joinPoint.proceed(new Object[] {((int) joinPoint.getArgs()[0]) + 360, "Ferrari"});
        log.info("AspectDemo.around2() end");
//        return ret;
        return null;
//        return -1;
    }
     */

}
