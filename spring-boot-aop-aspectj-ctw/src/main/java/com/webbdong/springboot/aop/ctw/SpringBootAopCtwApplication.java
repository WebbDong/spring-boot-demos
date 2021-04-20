package com.webbdong.springboot.aop.ctw;

import com.webbdong.springboot.aop.ctw.service.AspectDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AOP CTW 编译期织入
 *  需要将 idea 的编译器改为 Ajc 本地运行时才能织入，同时需要进行一些配置，否则 Ajc 编译器和 Lombok 会有不兼容问题，
 *  可参考: https://stackoverflow.com/questions/65119382/unable-to-enable-post-compile-weave-mode-in-intellij-for-a-module
 * @author Webb Dong
 * @date 2021-04-17 2:49 PM
 */
@SpringBootApplication
public class SpringBootAopCtwApplication implements CommandLineRunner {

    private AspectDemoService aspectDemoService;

    @Autowired
    public SpringBootAopCtwApplication(AspectDemoService aspectDemoService) {
        this.aspectDemoService = aspectDemoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopCtwApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        aspectDemoService.testAspectDemoMethod(500, "Pagani");
    }

}
