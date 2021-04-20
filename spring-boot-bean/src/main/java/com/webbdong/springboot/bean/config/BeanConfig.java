package com.webbdong.springboot.bean.config;

import com.webbdong.springboot.bean.model.Person;
import com.webbdong.springboot.bean.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 配置
 * @author Webb Dong
 * @date 2021-04-16 5:49 PM
 */
@Configuration
public class BeanConfig {

    @Bean
    public Person person() {
        return new Person("Adam");
    }

    @Bean
    public Student student() {
        return new Student("Ada", 80.5F);
    }

}
