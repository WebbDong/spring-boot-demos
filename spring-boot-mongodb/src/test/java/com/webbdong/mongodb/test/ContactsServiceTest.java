package com.webbdong.mongodb.test;

import com.webbdong.mongodb.service.ContactsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: Webb Dong
 * @date: 2021-11-29 11:43 PM
 */
@SpringBootTest
public class ContactsServiceTest {

    @Autowired
    private ContactsService contactsService;

    @Test
    public void testSaveContactsAndGroup() {
        contactsService.saveContactsAndGroup();
    }

    @Test
    public void testSaveContactsAndGroup2() {
        contactsService.saveContactsAndGroup2();
    }

}
