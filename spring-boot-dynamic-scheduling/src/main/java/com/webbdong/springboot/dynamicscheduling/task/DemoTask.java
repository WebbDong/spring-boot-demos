package com.webbdong.springboot.dynamicscheduling.task;

import org.springframework.stereotype.Component;

/**
 * @author Webb Dong
 * @date 2022-01-11 8:06 PM
 */
@Component
public class DemoTask {

    public void taskWithParams(String params) {
        System.out.println("执行有参示例任务：" + params);
    }

    public void taskNoParams() {
        System.out.println("执行无参示例任务");
    }

}