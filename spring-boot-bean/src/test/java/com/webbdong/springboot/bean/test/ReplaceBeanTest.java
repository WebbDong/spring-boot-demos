package com.webbdong.springboot.bean.test;

import com.webbdong.springboot.bean.model.Car;
import com.webbdong.springboot.bean.model.Person;
import com.webbdong.springboot.bean.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 替换覆盖 Spring 容器中的 Bean
 *  方法一 : 通过 BeanPostProcessor 接口实现
 * @author Webb Dong
 * @date 2021-04-16 5:18 PM
 */
@SpringBootTest
public class ReplaceBeanTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void test() {
        Person person = (Person) applicationContext.getBean("person");
        Student student = (Student) applicationContext.getBean("student");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(person);
        System.out.println(student);
        System.out.println(car);
        car.engineStart();

        Car car2 = (Car) applicationContext.getBean("car");
        System.out.println(car2);
    }

}
