package com.webbdong.springboot.redis.cache.web.controller;

import com.webbdong.springboot.redis.cache.model.dto.OrderMainDto;
import com.webbdong.springboot.redis.cache.model.mapper.OrderMainModelMapper;
import com.webbdong.springboot.redis.cache.model.query.OrderMainQuery;
import com.webbdong.springboot.redis.cache.model.vo.OrderMainVo;
import com.webbdong.springboot.redis.cache.model.vo.ResponseVo;
import com.webbdong.springboot.redis.cache.service.OrderMainService;
import com.webbdong.springboot.redis.cache.web.util.ResponseVoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单Controller
 */
@RestController
@RequestMapping("/order")
public class OrderMainController {

    private OrderMainService orderMainService;

    @Autowired
    public OrderMainController(OrderMainService orderMainService) {
        this.orderMainService = orderMainService;
    }

    @RequestMapping(value = "/getOrderPage", method = RequestMethod.POST)
    public ResponseVo getOrderPage(@RequestBody OrderMainQuery query) {
        List<OrderMainDto> orderList = orderMainService.getOrderPage(query);
        return ResponseVoUtils.success(OrderMainModelMapper.INSTANCE.dtoListToVoList(orderList));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseVo save(@RequestBody OrderMainVo orderMainVo) {
        OrderMainDto orderMainDto = OrderMainModelMapper.INSTANCE.voToDto(orderMainVo);
        orderMainService.saveWithDto(orderMainDto);
        return ResponseVoUtils.success();
    }

    @RequestMapping(value = "/getOrder", method = RequestMethod.POST)
    public ResponseVo getOrder(@RequestBody OrderMainVo orderMainVo) {
        OrderMainDto orderMainDto = OrderMainModelMapper.INSTANCE.voToDto(orderMainVo);
        List<OrderMainDto> orderMainDtoList = orderMainService.getOrder(orderMainDto);
        return ResponseVoUtils.success(OrderMainModelMapper.INSTANCE.dtoListToVoList(orderMainDtoList));
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    public ResponseVo updateOrder(@RequestBody OrderMainVo orderMainVo) {
        OrderMainDto orderMainDto = OrderMainModelMapper.INSTANCE.voToDto(orderMainVo);
        orderMainService.updateOrder(orderMainDto);
        return ResponseVoUtils.success();
    }

}
