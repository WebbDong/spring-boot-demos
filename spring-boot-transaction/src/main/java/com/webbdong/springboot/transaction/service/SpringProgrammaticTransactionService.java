package com.webbdong.springboot.transaction.service;

/**
 * 编程式事务
 */
public interface SpringProgrammaticTransactionService {

    void transactionCallback();

    void transactionCallbackWithoutResult();

    void rollback();

}
