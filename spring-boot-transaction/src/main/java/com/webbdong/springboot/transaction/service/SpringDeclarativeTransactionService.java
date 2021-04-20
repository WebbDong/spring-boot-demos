package com.webbdong.springboot.transaction.service;

import com.webbdong.springboot.transaction.exception.RollbackException;

/**
 * 声明式事务
 */
public interface SpringDeclarativeTransactionService {

    void insertRecord();

    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;

}
