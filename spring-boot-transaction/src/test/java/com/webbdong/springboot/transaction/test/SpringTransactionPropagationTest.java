package com.webbdong.springboot.transaction.test;

import com.webbdong.springboot.transaction.service.SpringTransactionPropagationService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Spring 事务传播性
 */
@SpringBootTest
public class SpringTransactionPropagationTest {

    @Autowired
    private SpringTransactionPropagationService springTransactionPropagationService;

    @SneakyThrows
    @Test
    public void testSpringTransactionPropagation() {
        springTransactionPropagationService.invokeInsertThenRollback();
    }

}
