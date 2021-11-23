package com.webbdong.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author: Webb Dong
 * @date: 2021-11-22 5:43 PM
 */
@Data
@Document(collection = "zips")
public class Zip {

    @Id
    private String id;

    private String city;

    private String[] ioc;

    private Integer pop;

    private String state;

}
