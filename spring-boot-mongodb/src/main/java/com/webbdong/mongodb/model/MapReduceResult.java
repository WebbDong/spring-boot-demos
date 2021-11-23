package com.webbdong.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: Webb Dong
 * @date: 2021-11-24 12:10 AM
 */
@Data
@Document(collection = "mapReduceResult")
public class MapReduceResult {

    @Id
    private String id;

    private String value;

}
