package com.webbdong.springboot.transaction.service.impl;

import com.webbdong.springboot.transaction.mapper.UserMapper;
import com.webbdong.springboot.transaction.service.SpringProgrammaticTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 编程式事务
 */
@Service
public class SpringProgrammaticTransactionServiceImpl implements SpringProgrammaticTransactionService {

    private UserMapper userMapper;

    private TransactionTemplate transactionTemplate;

    @Autowired
    public SpringProgrammaticTransactionServiceImpl(UserMapper userMapper,
                                                    TransactionTemplate transactionTemplate) {
        this.userMapper = userMapper;
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public void transactionCallback() {
        String result = transactionTemplate.execute((status) -> {
            userMapper.updateUserNameById("name30", 2L);
            return "SUCCESS";
        });
        System.out.println(result);
    }

    @Override
    public void transactionCallbackWithoutResult() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                userMapper.updateUserNameById("name100", 1L);
            }
        });

        transactionTemplate.executeWithoutResult((status) -> {
            userMapper.updateUserNameById("name500", 1L);
        });
    }

    @Override
    public void rollback() {
        transactionTemplate.executeWithoutResult((status) -> {
            userMapper.updateUserNameById("name9000", 1L);
            status.setRollbackOnly();
        });
    }

}
