package com.webbdong.springboot.redis.cache.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.webbdong.springboot.redis.cache.base.BaseServiceImpl;
import com.webbdong.springboot.redis.cache.consts.CacheNameConsts;
import com.webbdong.springboot.redis.cache.mapper.OrderMainMapper;
import com.webbdong.springboot.redis.cache.model.domain.OrderMainDo;
import com.webbdong.springboot.redis.cache.model.dto.OrderMainDto;
import com.webbdong.springboot.redis.cache.model.mapper.OrderMainModelMapper;
import com.webbdong.springboot.redis.cache.model.query.OrderMainQuery;
import com.webbdong.springboot.redis.cache.service.OrderMainService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单主表 服务实现类
 */
@Service
@CacheConfig(cacheNames = CacheNameConsts.REDIS_CACHE)
//@CacheConfig(cacheNames = "test")
public class OrderMainServiceImpl extends BaseServiceImpl<OrderMainMapper, OrderMainDo> implements OrderMainService {

    @Override
    public List<OrderMainDto> getOrderPage(OrderMainQuery query) {
        QueryWrapper<OrderMainDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(OrderMainDo.builder()
                .id(query.getId())
                .name(query.getName())
                .build());
        IPage<OrderMainDo> page = new Page<>();
        page.setCurrent(query.getCurrent());
        page.setSize(query.getSize());
        page = super.page(page, queryWrapper);
        return OrderMainModelMapper.INSTANCE.doListToDtoList(page.getRecords());
    }

    @Override
    public void saveWithDto(OrderMainDto orderMainDto) {
        OrderMainDo orderMainDo = OrderMainModelMapper.INSTANCE.dtoToDo(orderMainDto);
        orderMainDo.setVersion(0);
        super.save(orderMainDo);
    }

    @Cacheable(cacheNames = "getOrder", key = "#orderMainDto.id")
    @Override
    public List<OrderMainDto> getOrder(OrderMainDto orderMainDto) {
        QueryWrapper<OrderMainDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(OrderMainModelMapper.INSTANCE.dtoToDo(orderMainDto));
        List<OrderMainDo> orderMainDoList = super.list(queryWrapper);
        return OrderMainModelMapper.INSTANCE.doListToDtoList(orderMainDoList);
    }

    @CacheEvict(cacheNames = "getOrder", key = "#orderMainDto.id")
    @Override
    public void updateOrder(OrderMainDto orderMainDto) {
        OrderMainDo orderMainDo = OrderMainModelMapper.INSTANCE.dtoToDo(orderMainDto);
        super.updateById(orderMainDo);
    }

}
