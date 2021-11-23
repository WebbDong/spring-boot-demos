package com.webbdong.mongodb.repository;

import com.webbdong.mongodb.model.Zip;
import com.webbdong.mongodb.model.ZipAggregate;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: Webb Dong
 * @date: 2021-11-22 5:47 PM
 */
public interface ZipMongoRepository extends MongoRepository<Zip, String> {

    @Aggregation({
            "{$match: {state: {$in: ?0}}}",
            "{$group: {_id: '$state', count: {$sum: 1}}}",
            "{$sort: {state: 1}}",
            "{$project: {state: '$_id', count: true, _id: false}}"
    })
    AggregationResults<ZipAggregate> aggregate(String[] states);

}
