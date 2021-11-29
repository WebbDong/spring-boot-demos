package com.webbdong.mongodb.repository;

import com.webbdong.mongodb.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: Webb Dong
 * @date: 2021-11-29 11:42 PM
 */
public interface GroupMongoRepository extends MongoRepository<Group, String> {
}
