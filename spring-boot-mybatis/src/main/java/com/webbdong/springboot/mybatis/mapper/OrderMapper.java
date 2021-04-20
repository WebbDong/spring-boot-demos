package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 订单表 Mapper 接口
 * @author Webb Dong
 * @since 2021-03-13
 */
@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM t_order WHERE order_no LIKE #{orderNo}")
    List<Order> selectLikeOrderNo1(@Param("orderNo") String orderNo);

    List<Order> selectLikeOrderNo2(@Param("orderNo") String orderNo);

    List<Order> selectLikeOrderNo3(@Param("orderNo") String orderNo);

}
