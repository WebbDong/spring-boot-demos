package com.webbdong.springboot.aop.ltw;

import com.webbdong.springboot.aop.ltw.service.AspectDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AOP LTW 类加载期织入
 * 通过 aspectjweaver 和 spring-instrument 在类加载期织入
 * 命令行执行: java -javaagent:"./javaagent-jar/aspectjweaver-1.9.6.jar"  -javaagent:"./javaagent-jar/spring-instrument-5.3.5.jar" -jar spring-boot-aop-ltw-1.0-SNAPSHOT.jar
 */
@SpringBootApplication
public class SpringBootAopLtwApplication implements CommandLineRunner {

    private AspectDemoService aspectDemoService;

    @Autowired
    public SpringBootAopLtwApplication(AspectDemoService aspectDemoService) {
        this.aspectDemoService = aspectDemoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopLtwApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        aspectDemoService.testAspectDemoMethod(200, "Lamborghini");
    }

}
