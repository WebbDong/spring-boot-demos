package com.webbdong.springboot.transaction.service.impl;

import com.webbdong.springboot.transaction.entity.User;
import com.webbdong.springboot.transaction.exception.RollbackException;
import com.webbdong.springboot.transaction.mapper.UserMapper;
import com.webbdong.springboot.transaction.service.SpringTransactionPropagationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Spring 事务传播性
 *  PROPAGATION_REQUIRED：A如果有事务，B将使用该事务；如果A没有事务，B将创建一个新的事务，默认值
 *  PROPAGATION_SUPPORTS：A如果有事务，B将使用该事务；如果A没有事务，B将以非事务执行
 *  PROPAGATION_MANDATORY：A如果有事务，B将使用该事务；如果A没有事务，B将抛异常，用于必须有事务的场景
 *  PROPAGATION_REQUIRES_NEW：A如果有事务，将A的事务挂起，B创建一个新的事务；如果A没有事务，B创建一个新的事务，无论当前
 *      存不存在事务都创建新事务
 *  PROPAGATION_NOT_SUPPORTED：A如果有事务，将A的事务挂起，B将以非事务执行；如果A没有事务，B将以非事务执行，用于缩小事务的范围
 *  PROPAGATION_NEVER：A如果有事务，B将抛异常；A如果没有事务，B将以非事务执行
 *  PROPAGATION_NESTED：如果A存在事务则A和B底层采用保存点机制，
 *      形成嵌套事务，在进入 B 子事务之前 A 父事务会创建一个保存点（Save Point）然后在执行 B 事务，B 事务执行完后，再继续执行 A 事务，
 *      如果A没有事务，B将新建一个事务。
 *
 *      如果子事务回滚
 *          父事务会回滚到进入子事务前建立的保存点，所以父事务不会全部回滚，会继续执行。
 *      如果父事务回滚
 *          父事务回滚，子事务也会一起回滚。
 *      事务提交
 *          子事务先提交，再父事务提交。
 *
 *      总结: 子事务的回滚和提交不会影响到父事务，父事务回滚子事务也会回滚。
 */
@Service
public class SpringTransactionPropagationServiceImpl implements SpringTransactionPropagationService {

    private UserMapper userMapper;

    private SpringTransactionPropagationService propagationService;

    @Autowired
    public SpringTransactionPropagationServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setPropagationService(SpringTransactionPropagationService propagationService) {
        this.propagationService = propagationService;
    }

    @Transactional(rollbackFor = RollbackException.class, propagation = Propagation.REQUIRED)
    @Override
    public void insertThenRollback() throws RollbackException {
        User user = new User();
        user.setUserName("name3000");
        user.setPassword("abcdefg");
        user.setLastLoginTime(LocalDateTime.now());
        user.setSex(0);
        userMapper.save(user);
        throw new RollbackException();
    }

    @Transactional(rollbackFor = {RuntimeException.class, RollbackException.class})
    @Override
    public void invokeInsertThenRollback() throws RollbackException {
        User user = new User();
        user.setUserName("name2000");
        user.setPassword("456asdfbcde");
        user.setLastLoginTime(LocalDateTime.now());
        user.setSex(3);
        userMapper.save(user);

        try {
            propagationService.insertThenRollback();
        } catch (RollbackException e) {
            System.out.println("insertThenRollback回滚");
        }

//        throw new RuntimeException();
    }

}
