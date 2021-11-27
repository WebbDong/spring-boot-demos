package com.webbdong.mongodb.test;

import com.google.gson.Gson;
import com.webbdong.mongodb.model.ZipAggregate;
import com.webbdong.mongodb.repository.ZipMongoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

/**
 * @author: Webb Dong
 * @date: 2021-11-22 5:49 PM
 */
@SpringBootTest
public class ZipMongoRepositoryTest {

    @Autowired
    private ZipMongoRepository zipMongoRepository;

    @Test
    public void testAggregate() {
        String[] states = {"MA", "NH", "ME"};
        AggregationResults<ZipAggregate> aggregationResults = zipMongoRepository.aggregate(states);
        System.out.println(new Gson().toJson(aggregationResults.getMappedResults()));
    }

}
