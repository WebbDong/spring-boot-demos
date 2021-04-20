package com.webbdong.springboot.transaction.test;

import com.webbdong.springboot.transaction.service.SpringProgrammaticTransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 编程式事务
 */
@SpringBootTest
public class SpringProgrammaticTransactionTest {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private SpringProgrammaticTransactionService springProgrammaticTransactionService;

    @Test
    public void testTransactionCallback() {
        springProgrammaticTransactionService.transactionCallback();
    }

    @Test
    public void testTransactionCallbackWithoutResult() {
        springProgrammaticTransactionService.transactionCallbackWithoutResult();
    }

    @Test
    public void testRollback() {
        springProgrammaticTransactionService.rollback();
    }

}
