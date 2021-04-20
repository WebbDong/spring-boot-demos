package com.webbdong.springboot.aop.ctw.test;

import com.webbdong.springboot.aop.ctw.service.AspectDemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Webb Dong
 * @date 2021-04-17 3:01 PM
 */
@SpringBootTest
@Slf4j
public class AspectDemoServiceTest {

    @Autowired
    private AspectDemoService aspectDemoService;

    @Test
    public void testAspectDemoMethod() {
        aspectDemoService.testAspectDemoMethod(500, "Pagani");
    }

}
