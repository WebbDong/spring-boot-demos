package com.webbdong.springboot.mybatis.test;

import com.webbdong.springboot.mybatis.entity.Order;
import com.webbdong.springboot.mybatis.mapper.OrderMapper;
import com.webbdong.springboot.mybatis.utils.SnowFlake;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author Webb Dong
 * @date 2018-03-25 8:33 PM
 */
@SpringBootTest
public class OrderMapperTest {

    private OrderMapper orderMapper;

    @Autowired
    public OrderMapperTest(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Test
    public void testSelectLikeOrderNo1() {
        List<Order> orderList = orderMapper.selectLikeOrderNo1("%93161413%");
        System.out.println(orderList.size());
        System.out.println(orderList);
    }

    @Test
    public void testSelectLikeOrderNo2() {
        List<Order> orderList = orderMapper.selectLikeOrderNo2("93161413");
        System.out.println(orderList.size());
        System.out.println(orderList);
    }

    @Test
    public void testSelectLikeOrderNo3() {
        List<Order> orderList = orderMapper.selectLikeOrderNo3("93161413");
        System.out.println(orderList.size());
        System.out.println(orderList);
    }

    @Test
    public void testSelectOrderCascade() {
        List<Order> orderList = orderMapper.selectOrderCascade();
        System.out.println(orderList.size());
        System.out.println(orderList.get(0));
    }

    @Test
    public void testSelectOrderCascadeAnnotation() {
        List<Order> orderList = orderMapper.selectOrderCascadeAnnotation();
        System.out.println(orderList.size());
        System.out.println(orderList.get(0));
    }

    @Test
    public void testSelectOrderCascadeAnnotation2() {
        List<Order> orderVOList = orderMapper.selectOrderCascadeAnnotation2();
        System.out.println(orderVOList.size());
        System.out.println(orderVOList.get(0));
    }

    @Test
    public void testInsertReturnPK() {
        Order order = new Order();
        fillingOrder(order, 0);
        int count = orderMapper.insertReturnPK(order);
        System.out.println(count);
        System.out.println(order.getId());
    }

    @Test
    public void testBatchInsertReturnPK() {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Order order = new Order();
            fillingOrder(order, i);
            orderList.add(order);
        }
        int count = orderMapper.batchInsertReturnPK(orderList);
        System.out.println(count);
        final List<Long> idList = orderList.stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());
        System.out.println(idList);
    }

    @SneakyThrows
    private void fillingOrder(Order order, int i) {
        SnowFlake snowFlake = new SnowFlake(3, 6);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setUserId(snowFlake.nextId());
        // 优惠券id
        order.setCouponId(snowFlake.nextId());
        // 订单编号
        order.setOrderNo(String.valueOf(snowFlake.nextId()));
        // 订单总金额
        order.setTotalAmount(BigDecimal.valueOf(20.0 + i));
        // 应付金额
        order.setPayAmount(BigDecimal.valueOf(20.0 + i + 5));
        // 运费金额
        order.setFreightAmount(BigDecimal.valueOf(5));
        // 促销优化金额
        order.setPromotionAmount(BigDecimal.ZERO);
        // 积分抵扣金额
        order.setIntegrationAmount(BigDecimal.ZERO);
        // 优惠券抵扣金额
        order.setCouponAmount(BigDecimal.ZERO);
        // 支付方式
        order.setPayType(ThreadLocalRandom.current().nextInt(3));
        // 订单来源
        order.setSourceType(ThreadLocalRandom.current().nextInt(2));
        // 订单状态
        order.setStatus(3);
        // 订单类型
        order.setOrderType(ThreadLocalRandom.current().nextInt(2));
        // 配送物流公司
        order.setDeliveryCompany("UPS");
        // 物流单号
        order.setDeliveryNo("170916032679263331");
        // 自动确认时间
        order.setAutoConfirmDay(7);
        // 收货人姓名
        order.setReceiverName("Webb");
        // 收货人电话
        order.setReceiverPhone("13813838438");
        // 收货人邮编
        order.setReceiverPostCode("201700");
        // 省份/直辖市
        order.setReceiverProvince("上海");
        // 城市
        order.setReceiverCity("上海");
        // 区
        order.setReceiverRegion("青浦区");
        // 详细地址
        order.setReceiverDetailAddress("上海青浦区");
        // 订单备注
        order.setRemark("备注");
        // 确认收货状态
        order.setConfirmStatus(1);
        // 支付时间
        order.setPaymentTime(df.parse("2021-02-05 11:30:35"));
        // 发货时间
        order.setDeliveryTime(df.parse("2021-02-06 11:30:35"));
        // 确认收货时间
        order.setReceiveTime(df.parse("2021-02-07 11:30:35"));
        // 评价时间
        order.setCommentTime(df.parse("2021-02-08 11:30:35"));
        // 创建时间
        order.setCreatedTime(df.parse("2021-03-06 14:30:00"));
        // 修改时间
        order.setUpdatedTime(df.parse("2021-03-06 14:30:00"));
        // 删除状态
        order.setDelStatus(0);
    }

}
