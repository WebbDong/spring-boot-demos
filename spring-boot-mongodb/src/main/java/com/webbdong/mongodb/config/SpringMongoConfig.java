package com.webbdong.mongodb.config;

import com.mongodb.client.model.changestream.FullDocument;
import com.webbdong.mongodb.messagelistener.DocumentMessageListener;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.core.messaging.ChangeStreamRequest;
import org.springframework.data.mongodb.core.messaging.DefaultMessageListenerContainer;
import org.springframework.data.mongodb.core.messaging.MessageListenerContainer;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author: Webb Dong
 * @date: 2021-11-18 2:55 PM
 */
@Configuration
public class SpringMongoConfig {

    /**
     * 去除自动添加的 _class 字段
     */
    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDatabaseFactory mongoDatabaseFactory,
                                                       MongoMappingContext mongoMappingContext) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDatabaseFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }

    /**
     * MongoDB 事务管理器
     */
    @Bean
    public MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
        return new MongoTransactionManager(mongoDatabaseFactory);
    }

    /**
     * 配置 change stream 监听
     */
    @Bean
    public MessageListenerContainer messageListenerContainer(MongoTemplate template,
                                                             DocumentMessageListener documentMessageListener) {
        Executor executor = Executors.newSingleThreadExecutor();
        MessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer(template, executor) {
            @Override
            public boolean isAutoStartup() {
                return true;
            }
        };
        ChangeStreamRequest<Document> request = ChangeStreamRequest.builder(documentMessageListener)
                // 监听的集合名
                .collection("group")
                // 过滤需要监听的操作类型，可以根据需求指定过滤条件
                .filter(Aggregation.newAggregation(
                        Aggregation.match(Criteria.where("operationType").in("insert", "update", "replace"))))
                // 不设置时，文档更新时，只会发送变更字段的信息，设置UPDATE_LOOKUP会返回文档的全部信息
                .fullDocumentLookup(FullDocument.UPDATE_LOOKUP)
                .build();
        messageListenerContainer.register(request, Document.class);
        return messageListenerContainer;
    }

}
