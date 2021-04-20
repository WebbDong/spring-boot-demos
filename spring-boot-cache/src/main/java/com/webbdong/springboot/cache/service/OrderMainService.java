package com.webbdong.springboot.cache.service;

import com.webbdong.springboot.cache.base.BaseService;
import com.webbdong.springboot.cache.model.domain.OrderMainDo;
import com.webbdong.springboot.cache.model.dto.OrderMainDto;
import com.webbdong.springboot.cache.model.query.OrderMainQuery;

import java.util.List;

/**
 * 订单主表 服务类
 */
public interface OrderMainService extends BaseService<OrderMainDo> {

    List<OrderMainDto> getOrderPage(OrderMainQuery query);

    void saveWithDto(OrderMainDto orderMainDto);

    List<OrderMainDto> getOrder(OrderMainDto orderMainDto);

    void updateOrder(OrderMainDto orderMainDto);

}
