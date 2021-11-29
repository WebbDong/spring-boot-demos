package com.webbdong.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author: Webb Dong
 * @date: 2021-11-29 10:50 PM
 */
@Data
@Document(collection = "contacts")
public class Contacts {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("mobile")
    private String mobile;

    @Field("groupIds")
    private Integer[] groupIds;

}
