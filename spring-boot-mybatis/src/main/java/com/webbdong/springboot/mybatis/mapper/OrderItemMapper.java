package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.Order;
import com.webbdong.springboot.mybatis.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Webb Dong
 * @date 2018-04-22 3:50 PM
 */
@Mapper
public interface OrderItemMapper {

    @Select("SELECT * FROM t_order_item WHERE order_id = #{0}")
    List<OrderItem> selectByOrderId(String orderId);

    OrderItem selectCascadeById(Long id);

    @Select("SELECT * FROM t_order_item WHERE id = #{0}")
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "order",
                    column = "order_id",
                    javaType = Order.class,
                    one = @One(fetchType = FetchType.LAZY,
                               select = "com.webbdong.springboot.mybatis.mapper.OrderMapper.selectById"))
    })
    OrderItem selectCascadeByIdAnnotation(Long id);

}
