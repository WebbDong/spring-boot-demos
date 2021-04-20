package com.webbdong.springboot.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Webb Dong
 * @date 2021-04-16 2:03 PM
 */
public class PointcutDef {

    // 将切点方法定义成 static 可以在多个切面中使用
    @Pointcut("execution(public * com.webbdong.springboot.aop.dao.mapper.OrderMainMapper.*(..))")
    public static void pointcut() {
    }

}
