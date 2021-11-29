package com.webbdong.mongodb.repository;

import com.webbdong.mongodb.model.Contacts;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: Webb Dong
 * @date: 2021-11-29 11:41 PM
 */
public interface ContactsMongoRepository extends MongoRepository<Contacts, String> {
}
