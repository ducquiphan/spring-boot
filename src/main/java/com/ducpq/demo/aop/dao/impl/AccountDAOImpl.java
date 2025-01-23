/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.dao.impl;

import com.ducpq.demo.aop.dao.AccountDAO;
import com.ducpq.demo.aop.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * AccountDAO
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-17
 */
@Repository
public class AccountDAOImpl implements AccountDAO {
	
	private String name;
	private String serviceCode;
	
	/**
	 *
	 */
	@Override
	public void addAccount() {
		System.out.println(getClass() + ": Executing addAccount()");
	}
	
	/**
	 * @param account
	 * @param isAdding
	 */
	@Override
	public void addAccount(Account account, boolean isAdding) {
		System.out.println(getClass() + ": Executing addAccount(Account account, boolean isAdding)");
	}
	
	@Override
	public String getName() {
		System.out.println(getClass() + ": Executing getName()");
		return name;
	}
	
	@Override
	public void setName(String name) {
		System.out.println(getClass() + ": Executing setName()");
		this.name = name;
	}
	
	@Override
	public String getServiceCode() {
		System.out.println(getClass() + ": Executing getServiceCode()");
		return serviceCode;
	}
	
	@Override
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": Executing setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
}
