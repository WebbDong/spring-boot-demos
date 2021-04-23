package com.webbdong.springboot.mvc.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.webbdong.springboot.mvc.enums.GenderEnum;
import com.webbdong.springboot.mvc.enums.StringEnumSerializer;
import com.webbdong.springboot.mvc.enums.WeekendEnum;
import com.webbdong.springboot.mvc.jackson.EnumTypeJsonSerializer;
import lombok.Builder;
import lombok.Data;

/**
 * @author Webb Dong
 * @date 2021-04-23 4:39 PM
 */
@Builder
@Data
public class ResponseVO {

    @JsonSerialize(using = EnumTypeJsonSerializer.class)
    private WeekendEnum weekend;

    @StringEnumSerializer(enumClass = WeekendEnum.class, displayFieldName = "desc")
    private String weekendCode;

    private GenderEnum gender;

}
