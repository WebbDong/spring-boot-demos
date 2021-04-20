package com.webbdong.springboot.aop.ctw.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AspectDemoService {

    public void testAspectDemoMethod(int num, String str) {
        log.info("Target Method AspectDemoService.testAspectDemoMethod() num = {}, str = {}", num, str);
//        throw new RuntimeException();
    }

}
