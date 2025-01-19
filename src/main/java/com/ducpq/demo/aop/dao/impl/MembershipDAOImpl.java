/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.dao.impl;

import com.ducpq.demo.aop.dao.MembershipDAO;
import org.springframework.stereotype.Repository;

/**
 * AccountDAO
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-17
 */
@Repository
public class MembershipDAOImpl implements MembershipDAO {
	/**
	 *
	 */
	@Override
	public void addAccount() {
		System.out.println(getClass() + ": Executing addAccount()");
	}
	
	/**
	 *
	 */
	@Override
	public void addRole() {
		System.out.println(getClass() + ": Executing addRole()");
	}
}
