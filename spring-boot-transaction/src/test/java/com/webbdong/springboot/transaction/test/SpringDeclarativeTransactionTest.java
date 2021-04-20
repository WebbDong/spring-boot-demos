package com.webbdong.springboot.transaction.test;

import com.webbdong.springboot.transaction.exception.RollbackException;
import com.webbdong.springboot.transaction.service.SpringDeclarativeTransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 声明式事务
 */
@SpringBootTest
public class SpringDeclarativeTransactionTest {

    @Autowired
    private SpringDeclarativeTransactionService declarativeTransactionService;

    @Test
    public void testInsertRecord() {
        declarativeTransactionService.insertRecord();
    }

    @Test
    public void testInsertThenRollback() {
        try {
            declarativeTransactionService.insertThenRollback();
        } catch (RollbackException e) {
            System.out.println("回滚");
        }
    }

    @Test
    public void testInvokeInsertThenRollback() {
        try {
            declarativeTransactionService.invokeInsertThenRollback();
        } catch (RollbackException e) {
            System.out.println("回滚");
        }
    }

}
