package com.webbdong.elasticsearch.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author WebbDong
 * @createTime 2023-10-17 13:06
 */
@RequiredArgsConstructor(onConstructor_={@Autowired})
//@Configuration
@Slf4j
public class ElasticsearchConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(RestClient.builder(new HttpHost(
                "192.168.0.104", 5601, "http"))
                .setRequestConfigCallback(requestConfigBuilder -> {
                    requestConfigBuilder.setConnectionRequestTimeout(10000);
                    requestConfigBuilder.setSocketTimeout(10000);
                    requestConfigBuilder.setConnectTimeout(10000);
                    return requestConfigBuilder;
                }));
    }

}
