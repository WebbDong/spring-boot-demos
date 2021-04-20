package com.webbdong.springboot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AOP相关概念
 * 一、切面（Aspect）
 *      是切入点和通知的结合。在spring中使用切面类来表示使用@Aspect注解
 *
 * 二、连接点（Join point）
 *      连接点就是可以使用通知进行增强的方法
 *
 * 三、通知（Advice）
 *      就是会在目标方法执行前后执行的方法
 *      Spring AOP 提供了5种类型的通知：
 *          前置通知（Before）：在目标方法被调用之前调用通知功能。
 *          后置通知（After）：在目标方法完成之后调用通知，无论该方法是否发生异常。
 *          后置返回通知（After-returning）：在目标方法成功执行之后调用通知。
 *          后置异常通知（After-throwing）：在目标方法抛出异常后调用通知。
 *          环绕通知（Around）：在方法执行前和执行后都会执行
 *
 * 四、切点（Pointcut）
 *      应用通知进行增强的目标方法
 *
 * 五、引入（Introduction）
 *      在不改变一个现有类代码的情况下，为该类添加属性和方法,可以在无需修改现有类的前提下，让它们具有新的行为和状态。其实就是把切面（也就是新方法属性：通知定义的）用到目标类中去
 *
 * 六、目标对象（Target Object）
 *      被通知的对象。也就是需要加入额外代码的对象，也就是真正的业务逻辑被组织织入切面。也被称作被通知或被代理对象。
 *
 * 七、AOP代理（AOP Proxy）
 *      AOP框架创建的对象，包含通知。 在Spring中，AOP代理可以是JDK动态代理或者CGLIB代理。
 *
 * 八、织入(Weaving)
 *      织入描述的是把切面应用到目标对象来创建新的代理对象的过程。 Spring AOP 的切面是在运行时被织入，原理是使用了动态代理技术。
 *      Spring支持两种方式生成代理对象：JDK动态代理和CGLib，默认的策略是如果目标类是接口，则使用JDK动态代理技术，否则使用Cglib来生成代理。
 *      在目标对象的生命周期里有多个点可以进行织入：
 *          编译期（Compile Time Weaving、CTW）：切面在目标类编译时被织入，这种方式需要特殊的编译器
 *          类加载期 (Load Time Weaving、LTW)：切面在目标类加载到JVM时被织入，这种方式需要特殊的类加载器，它可以在目标类被引入应用之前增强该目标类的字节码
 *          运行期（Run-time Weaving、RTW）：切面在应用运行的某个时刻被织入，一般情况下，在织入切面时，AOP容器会为目标对象动态创建一个代理对象，Spring AOP就是以这种方式织入切面的。
 */
@SpringBootApplication
public class SpringBootAopApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

}
