/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.dao;

import com.ducpq.demo.aop.entity.Account;

import java.util.List;

/**
 * AccountDAO
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-17
 */
public interface AccountDAO {
	void addAccount();
	
	void addAccount(Account account, boolean isAdding);
	
	String getName();
	
	void setName(String name);
	
	String getServiceCode();
	
	void setServiceCode(String serviceCode);
	
	List<Account> findAccounts();
	
	List<Account> findAccounts(boolean tripWire);
	
}
