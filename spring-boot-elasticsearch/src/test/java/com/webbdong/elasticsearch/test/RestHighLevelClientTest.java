package com.webbdong.elasticsearch.test;

import com.webbdong.elasticsearch.App;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author WebbDong
 * @createTime 2023-10-17 13:21
 */
@SpringBootTest(classes = App.class)
public class RestHighLevelClientTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void test() {
    }

}
