package com.webbdong.elasticsearch.test;

import com.webbdong.elasticsearch.App;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * @author WebbDong
 * @createTime 2023-10-18 19:33
 */
@SpringBootTest(classes = App.class)
public class ElasticsearchRestTemplateTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void test() {
    }

}
