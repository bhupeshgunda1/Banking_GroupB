package com.aabms.assignment4.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountsDao {
	
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
	public float updateBalance(String custid, String depositedBalance) {
		float updatedBalance = 0;
		try {
			String prevBalance = "select Balance from Accounts where Cust_ID='" + custid +"';";
			updatedBalance = 	Float.parseFloat(prevBalance) + Float.parseFloat(depositedBalance);
			System.out.println("updated balance " + updatedBalance);
			String sql = "update Accounts set Balance=" + updatedBalance + " where Cust_ID='" + custid + "'";
			template.update(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedBalance;
		
	}


	
}
