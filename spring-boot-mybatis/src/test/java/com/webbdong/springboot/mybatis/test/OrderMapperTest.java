package com.webbdong.springboot.mybatis.test;

import com.webbdong.springboot.mybatis.entity.onetomany.Order;
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
        // ?????????id
        order.setCouponId(snowFlake.nextId());
        // ????????????
        order.setOrderNo(String.valueOf(snowFlake.nextId()));
        // ???????????????
        order.setTotalAmount(BigDecimal.valueOf(20.0 + i));
        // ????????????
        order.setPayAmount(BigDecimal.valueOf(20.0 + i + 5));
        // ????????????
        order.setFreightAmount(BigDecimal.valueOf(5));
        // ??????????????????
        order.setPromotionAmount(BigDecimal.ZERO);
        // ??????????????????
        order.setIntegrationAmount(BigDecimal.ZERO);
        // ?????????????????????
        order.setCouponAmount(BigDecimal.ZERO);
        // ????????????
        order.setPayType(ThreadLocalRandom.current().nextInt(3));
        // ????????????
        order.setSourceType(ThreadLocalRandom.current().nextInt(2));
        // ????????????
        order.setStatus(3);
        // ????????????
        order.setOrderType(ThreadLocalRandom.current().nextInt(2));
        // ??????????????????
        order.setDeliveryCompany("UPS");
        // ????????????
        order.setDeliveryNo("170916032679263331");
        // ??????????????????
        order.setAutoConfirmDay(7);
        // ???????????????
        order.setReceiverName("Webb");
        // ???????????????
        order.setReceiverPhone("13813838438");
        // ???????????????
        order.setReceiverPostCode("201700");
        // ??????/?????????
        order.setReceiverProvince("??????");
        // ??????
        order.setReceiverCity("??????");
        // ???
        order.setReceiverRegion("?????????");
        // ????????????
        order.setReceiverDetailAddress("???????????????");
        // ????????????
        order.setRemark("??????");
        // ??????????????????
        order.setConfirmStatus(1);
        // ????????????
        order.setPaymentTime(df.parse("2021-02-05 11:30:35"));
        // ????????????
        order.setDeliveryTime(df.parse("2021-02-06 11:30:35"));
        // ??????????????????
        order.setReceiveTime(df.parse("2021-02-07 11:30:35"));
        // ????????????
        order.setCommentTime(df.parse("2021-02-08 11:30:35"));
        // ????????????
        order.setCreatedTime(df.parse("2021-03-06 14:30:00"));
        // ????????????
        order.setUpdatedTime(df.parse("2021-03-06 14:30:00"));
        // ????????????
        order.setDelStatus(0);
    }

}
