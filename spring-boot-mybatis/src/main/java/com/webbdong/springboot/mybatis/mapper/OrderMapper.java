package com.webbdong.springboot.mybatis.mapper;

import com.webbdong.springboot.mybatis.entity.Order;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单表 Mapper 接口
 * @author Webb Dong
 * @since 2018-03-25
 */
@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM t_order WHERE id = #{0}")
    Order selectById(Long id);

    /**
     * 模糊查询写法一
     */
    @Select("SELECT * FROM t_order WHERE order_no LIKE #{orderNo}")
    List<Order> selectLikeOrderNo1(@Param("orderNo") String orderNo);

    /**
     * 模糊查询写法二
     */
    List<Order> selectLikeOrderNo2(@Param("orderNo") String orderNo);

    /**
     * 模糊查询写法三
     */
    List<Order> selectLikeOrderNo3(@Param("orderNo") String orderNo);

    /**
     * XML 级联查询
     */
    List<Order> selectOrderCascade();

    /**
     * 注解级联查询
     * 直接使用 XML 映射文件中 id 为 orderVOCascade 的 <resultMap>
     */
    @Select("SELECT * FROM t_order LIMIT 20")
    @ResultMap("orderCascade")
    List<Order> selectOrderCascadeAnnotation();

    /**
     * 注解级联查询
     */
    @Select("SELECT * FROM t_order LIMIT 20")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(column = "id",
                    property = "orderItemList",
                    javaType = ArrayList.class,
                    many = @Many(fetchType = FetchType.LAZY,
                                 select = "com.webbdong.springboot.mybatis.mapper.OrderItemMapper.selectByOrderId"))
    })
    List<Order> selectOrderCascadeAnnotation2();

    /**
     * 插入数据并返回自增主键
     */
    int insertReturnPK(@Param("order") Order order);

    /**
     * 批量插入数据并返回自增主键
     */
    int batchInsertReturnPK(@Param("orderList") List<Order> orderList);

}
