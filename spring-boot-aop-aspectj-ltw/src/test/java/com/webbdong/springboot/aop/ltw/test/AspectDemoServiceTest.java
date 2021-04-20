package com.webbdong.springboot.aop.ltw.test;

import com.webbdong.springboot.aop.ltw.service.AspectDemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AspectDemoServiceTest {

    @Autowired
    private AspectDemoService aspectDemoService;

    /*
        配置 JVM 参数
        -javaagent:"D:/develop/tools/apache-maven-3.6.3-bin/repository/org/aspectj/aspectjweaver/1.9.6/aspectjweaver-1.9.6.jar"
        -javaagent:"D:/develop/tools/apache-maven-3.6.3-bin/repository/org/springframework/spring-instrument/5.3.5/spring-instrument-5.3.5.jar"
     */
    @Test
    public void testAspectDemoMethod() {
        aspectDemoService.testAspectDemoMethod(100, "Ferrari");
    }

}
