package com.webbdong.springboot.aop.test;

import com.webbdong.springboot.aop.service.AspectDemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AspectDemoServiceTest {

    @Autowired
    private AspectDemoService aspectDemoService;

    @Test
    public void testAspectDemoMethod() {
        aspectDemoService.testAspectDemoMethod(100, "Ferrari");
    }

    @Test
    public void testAspectDemoMethod2() {
        Integer ret = aspectDemoService.testAspectDemoMethod2(600, "Lamborghini");
        log.info("ret = " + ret);
    }

}
