package com.webbdong.springboot.cache.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base Service实现抽象类
 * @param <M> Mapper
 * @param <D> 实体类
 */
public abstract class BaseServiceImpl<M extends MyBaseMapper<D>, D> extends ServiceImpl<M, D> implements BaseService<D> {

    @Autowired
    protected M myBaseMapper;

}
