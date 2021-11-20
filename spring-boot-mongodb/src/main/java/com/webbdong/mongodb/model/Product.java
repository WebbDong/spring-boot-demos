package com.webbdong.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

/**
 * @author: Webb Dong
 * @date: 2021-11-18 12:24 PM
 */
@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;

    @Field("name")
//    @Indexed 用于声明字段需要索引
    private String name;

    @Field("price")
    private BigDecimal price;

}
