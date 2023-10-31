package com.webbdong.elasticsearch.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webbdong.elasticsearch.App;
import com.webbdong.elasticsearch.entity.VirtualCharacter;
import com.webbdong.elasticsearch.util.JsonUtils;
import lombok.SneakyThrows;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.script.mustache.SearchTemplateRequest;
import org.elasticsearch.script.mustache.SearchTemplateResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WebbDong
 * @createTime 2023-10-17 13:21
 */
@SpringBootTest(classes = App.class)
public class RestHighLevelClientTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @SneakyThrows
    @Test
    public void testSearchTemplate() {
        SearchTemplateRequest templateRequest = new SearchTemplateRequest();
        // 指定索引
        templateRequest.setRequest(new SearchRequest("virtual-character"));
        // 设置为内联
        templateRequest.setScriptType(ScriptType.INLINE);
        templateRequest.setScript("{\"query\":{\"wildcard\":{\"mbti\":{\"value\":\"*P*\"}}},\"sort\":[{\"id\":{\"order\":\"desc\"}}],\"from\":{{from}},\"size\":{{size}}}");
        Map<String, Object> params = new HashMap<>();
        params.put("from", 0);
        params.put("size", 10);
        templateRequest.setScriptParams(params);
        SearchTemplateResponse response = restHighLevelClient.searchTemplate(templateRequest, RequestOptions.DEFAULT);
//        response.getResponse().getHits().forEach(System.out::println);
        response.getResponse().getHits().forEach((hit) -> {
            try {
                VirtualCharacter vc = JsonUtils.parseObj(hit.getSourceAsString(), VirtualCharacter.class);
                System.out.println(vc);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
