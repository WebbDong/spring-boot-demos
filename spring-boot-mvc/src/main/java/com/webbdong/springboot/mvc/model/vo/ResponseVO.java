package com.webbdong.springboot.mvc.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.webbdong.springboot.mvc.enums.GenderEnum;
import com.webbdong.springboot.mvc.enums.StringEnumSerializer;
import com.webbdong.springboot.mvc.enums.WeekendEnum;
import com.webbdong.springboot.mvc.jackson.EnumTypeJsonSerializer;
import lombok.Builder;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public static void main(String[] args) {
        Date d = new Date();
        d.setTime(1620309038166L);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(d));
    }

}
