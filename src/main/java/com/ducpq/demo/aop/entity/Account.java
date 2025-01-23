/*
 * Copyright by Duc Phan-Qui (c) 2025.
 */

package com.ducpq.demo.aop.entity;

/**
 * Account
 *
 * @author Admin
 * @version 1.0
 * @since 2025-01-23
 */
public class Account {
	
	private String username;
	
	
	private String password;
	
	public Account() {
		this.username = "admin";
		this.password = "<PASSWORD>";
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
