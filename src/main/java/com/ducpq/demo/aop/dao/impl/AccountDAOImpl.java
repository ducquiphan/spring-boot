/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.dao.impl;

import com.ducpq.demo.aop.dao.AccountDAO;
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
	/**
	 *
	 */
	@Override
	public void addAccount() {
		System.out.println(getClass() + ": Executing addAccount()");
	}
}
