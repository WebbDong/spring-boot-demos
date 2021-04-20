package com.webbdong.springboot.transaction.service;

import com.webbdong.springboot.transaction.exception.RollbackException;

/**
 * Spring 事务传播性
 */
public interface SpringTransactionPropagationService {

    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;

}
