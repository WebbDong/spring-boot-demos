package com.webbdong.springboot.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Webb Dong
 * @date 2021-04-24 1:09 PM
 */
@Controller
public class PageController {

    @GetMapping("/page/hellowebsocket")
    public String helloWebsocketPage() {
        return "HelloWebsocket";
    }

}
