package com.webbdong.springboot.yml.controller;

import com.webbdong.springboot.yml.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @Value("${person.name}")
    private String personName;

    @Value("${person.age}")
    private String personAge;

    @Autowired
    private Person personData;

    /**
     * 使用 SpringEL 获取数组数据
     */
    @Value("#{'${weeks2}'.split(',')}")
    private String[] weeks2;

    @Value("#{${maps2}}")
    private Map<String, String> maps2;

    @RequestMapping("/person")
    public String data() {
        return personName + "," + personAge;
    }

    @RequestMapping("/weeks2")
    public String[] weeks2() {
        return weeks2;
    }

    @RequestMapping("/maps2")
    public Map<String, String> maps2() {
        return maps2;
    }

    @RequestMapping("/personData")
    public Object personData() {
        System.out.println(personData);
        return personData;
    }

}
