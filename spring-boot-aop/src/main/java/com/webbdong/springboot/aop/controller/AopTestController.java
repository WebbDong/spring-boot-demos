package com.webbdong.springboot.aop.controller;

import com.webbdong.springboot.aop.service.AspectDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope
public class AopTestController {

    private AspectDemoService aspectDemoService;

    @Autowired
    public AopTestController(AspectDemoService aspectDemoService) {
        this.aspectDemoService = aspectDemoService;
    }

    @RequestMapping("/test")
    public String test() {
        aspectDemoService.testAspectDemoMethod(100, "Ferrari");
        return "success";
    }

}
