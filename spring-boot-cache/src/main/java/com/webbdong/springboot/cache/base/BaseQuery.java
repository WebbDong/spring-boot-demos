package com.webbdong.springboot.cache.base;

import lombok.Data;

@Data
public abstract class BaseQuery {

    private int current;

    private int size;

}
