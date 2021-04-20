package com.webbdong.springboot.aop.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.webbdong.springboot.aop.dao.mapper.OrderMainMapper;
import com.webbdong.springboot.aop.model.domain.OrderMain;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class OrderMainMapperTest {

    @Autowired
    private OrderMainMapper orderMainMapper;

    @Test
    public void test() {
        QueryWrapper<OrderMain> queryWrapper = new QueryWrapper<>();
        List<OrderMain> orderMainList = orderMainMapper.selectList(queryWrapper);
        log.info("orderMainList = {}", orderMainList);
    }

}
