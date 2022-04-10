package com.aabms.assignment4.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountsDao {
	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
}
