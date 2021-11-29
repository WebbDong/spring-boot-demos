package com.webbdong.mongodb.service.impl;

import com.webbdong.mongodb.model.Contacts;
import com.webbdong.mongodb.model.Group;
import com.webbdong.mongodb.repository.ContactsMongoRepository;
import com.webbdong.mongodb.repository.GroupMongoRepository;
import com.webbdong.mongodb.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.SessionSynchronization;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author: Webb Dong
 * @date: 2021-11-29 11:40 PM
 */
@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsMongoRepository contactsMongoRepository;

    @Autowired
    private GroupMongoRepository groupMongoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoTransactionManager mongoTransactionManager;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveContactsAndGroup() {
        Contacts contacts = new Contacts();
        contacts.setName("James");
        contacts.setMobile("13566987745");
        contacts.setGroupIds(new Integer[] {4});
        contactsMongoRepository.insert(contacts);

        Group group = new Group();
        group.setId(4);
        group.setName("group4");
        groupMongoRepository.insert(group);

        int i = 1 / 0;
    }

    @Override
    public void saveContactsAndGroup2() {
        mongoTemplate.setSessionSynchronization(SessionSynchronization.ALWAYS);
        TransactionTemplate transactionTemplate = new TransactionTemplate(mongoTransactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                Contacts contacts = new Contacts();
                contacts.setName("James");
                contacts.setMobile("13566987745");
                contacts.setGroupIds(new Integer[] {4});
                contactsMongoRepository.insert(contacts);

                Group group = new Group();
                group.setId(4);
                group.setName("group4");
                groupMongoRepository.insert(group);

//                int i = 1 / 0;
            }
        });
    }

}
