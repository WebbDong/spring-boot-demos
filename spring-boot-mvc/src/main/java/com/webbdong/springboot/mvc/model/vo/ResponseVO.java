package com.webbdong.springboot.mvc.model.vo;

import com.webbdong.springboot.mvc.enums.WeekendEnum;
import lombok.Builder;
import lombok.Data;

/**
 * @author Webb Dong
 * @date 2021-04-23 4:39 PM
 */
@Builder
@Data
public class ResponseVO {

    private WeekendEnum weekend;

}
