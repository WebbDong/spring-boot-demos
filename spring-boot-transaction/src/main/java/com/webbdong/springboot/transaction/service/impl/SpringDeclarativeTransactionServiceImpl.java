package com.webbdong.springboot.transaction.service.impl;

import com.webbdong.springboot.transaction.entity.User;
import com.webbdong.springboot.transaction.exception.RollbackException;
import com.webbdong.springboot.transaction.mapper.UserMapper;
import com.webbdong.springboot.transaction.service.SpringDeclarativeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * 声明式事务
 */
@Service
public class SpringDeclarativeTransactionServiceImpl implements SpringDeclarativeTransactionService {

    private UserMapper userMapper;

    private SpringDeclarativeTransactionService transactionService;

    @Autowired
    public SpringDeclarativeTransactionServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setTransactionService(SpringDeclarativeTransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Transactional
    @Override
    public void insertRecord() {
        User user = new User();
        user.setUserName("name100");
        user.setPassword("789456123wer");
        user.setLastLoginTime(LocalDateTime.now());
        user.setSex(2);
        userMapper.save(user);
    }

    @Transactional(rollbackFor = RollbackException.class)
    @Override
    public void insertThenRollback() throws RollbackException {
        User user = new User();
        user.setUserName("name1000");
        user.setPassword("abcdefg");
        user.setLastLoginTime(LocalDateTime.now());
        user.setSex(0);
        userMapper.save(user);
        throw new RollbackException();
    }

//    @Transactional(rollbackFor = RollbackException.class)
    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        // 不可以通过 this 调用自己的方法，否则事务会失效
//        insertThenRollback();
        transactionService.insertThenRollback();
    }

}
