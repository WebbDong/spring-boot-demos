package com.webbdong.springboot.aop.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Webb Dong
 * @date 2022-02-26 10:23 PM
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TestRequest extends CommonRequest {

    private String type;

}
