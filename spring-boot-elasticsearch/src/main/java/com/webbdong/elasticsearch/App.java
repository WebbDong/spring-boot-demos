package com.webbdong.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author WebbDong
 * @createTime 2023-10-17 01:49
 */
@SpringBootApplication
@ServletComponentScan
@EnableElasticsearchRepositories(basePackages = "com.webbdong.elasticsearch")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
