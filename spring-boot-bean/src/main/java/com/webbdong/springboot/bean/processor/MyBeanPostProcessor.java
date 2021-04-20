package com.webbdong.springboot.bean.processor;

import com.webbdong.springboot.bean.model.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 方法一、实现 BeanPostProcessor 接口进行 Bean 替换
 * @author Webb Dong
 * @date 2021-04-16 6:43 PM
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 将 BeanName 为 car 的 Bean 替换
        if ("car".equals(beanName)) {
            // 注册新创建的对象到 Spring 容器，注册为单例 Bean
            Car newCar = new Car("Lamborghini", 750);
            System.out.println("MyBeanPostProcessor newCar : " + newCar);
            return newCar;
        }
        return bean;
    }

}
