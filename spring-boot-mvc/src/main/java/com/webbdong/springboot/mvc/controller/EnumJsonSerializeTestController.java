package com.webbdong.springboot.mvc.controller;

import com.webbdong.springboot.mvc.enums.GenderEnum;
import com.webbdong.springboot.mvc.enums.WeekendEnum;
import com.webbdong.springboot.mvc.model.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Webb Dong
 * @date 2021-04-23 4:37 PM
 */
@RestController
public class EnumJsonSerializeTestController {

    @RequestMapping("/test")
    public ResponseVO test() {
        return ResponseVO.builder()
                .weekend(WeekendEnum.MONDAY)
                .weekendCode("0")
                .gender(GenderEnum.MALE)
                .build();
    }

}
