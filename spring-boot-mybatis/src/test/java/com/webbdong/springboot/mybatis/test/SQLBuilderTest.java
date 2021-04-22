package com.webbdong.springboot.mybatis.test;

import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SQL 语句构建器
 * @author Webb Dong
 * @date 2018-03-25 2:36 PM
 */
@SpringBootTest
public class SQLBuilderTest {

    @Test
    public void test() {
        String sql = new SQL()
                .SELECT("*")
                .FROM("t_order")
                .WHERE("order_no LIKE #{orderNo}")
                .toString();
        System.out.println(sql);
    }

}
