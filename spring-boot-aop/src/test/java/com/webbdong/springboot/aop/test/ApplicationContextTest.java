package com.webbdong.springboot.aop.test;

import com.webbdong.springboot.aop.service.AspectDemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @author Webb Dong
 * @description:
 * @date 2021-02-17 8:38 PM
 */
@SpringBootTest
@Slf4j
public class ApplicationContextTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AspectDemoService aspectDemoService;

    @Test
    public void test() {
        Object aspectDemoService1 = applicationContext.getBean("aspectDemoService");
        Object aspectDemoService2 = applicationContext.getBean("aspectDemoService");
        System.out.println("aspectDemoService1 = " + aspectDemoService1);
        System.out.println("aspectDemoService2 = " + aspectDemoService2);
        System.out.println("aspectDemoService = " + aspectDemoService);
    }

}
