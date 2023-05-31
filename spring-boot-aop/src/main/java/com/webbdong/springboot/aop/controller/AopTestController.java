package com.webbdong.springboot.aop.controller;

import com.webbdong.springboot.aop.annotation.MyAnnotation;
import com.webbdong.springboot.aop.model.request.TestRequest;
import com.webbdong.springboot.aop.service.AspectDemoService;
import com.webbdong.springboot.aop.util.JSONUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/test2")
    @SneakyThrows
    public Object test2(@RequestBody TestRequest request) {
        return JSONUtils.toJSON(request);
    }

    @RequestMapping("/test3")
    @MyAnnotation(param1 = 1000)
    public Object test3() {
        return "success";
    }

}
