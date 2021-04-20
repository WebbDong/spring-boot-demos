package com.webbdong.springboot.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
//@Scope("prototype")
@Slf4j
public class AspectDemoService {

    public void testAspectDemoMethod(int num, String str) {
        log.info("Target Method AspectDemoService.testAspectDemoMethod() num = {}, str = {}", num, str);
//        throw new RuntimeException();
    }

    public Integer testAspectDemoMethod2(int num, String str) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();
        log.info("Target Method AspectDemoService.testAspectDemoMethod2() num = {}, str = {}", num, str);
//        int i = 1 / 0;
        return num * 100;
    }

}
