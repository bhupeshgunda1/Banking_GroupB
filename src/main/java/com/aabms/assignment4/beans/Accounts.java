package com.aabms.assignment4.beans;

public class Accounts {

	private int Account_number;
	private int Account_Type_ID;
	private String Cust_ID;
	private float Balance;
	
	public int getAccount_number() {
		return Account_number;
	}
	public void setAccount_number(int account_number) {
		Account_number = account_number;
	}
	public int getAccount_Type_ID() {
		return Account_Type_ID;
	}
	public void setAccount_Type_ID(int account_Type_ID) {
		Account_Type_ID = account_Type_ID;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
	public float getBalance() {
		return Balance;
	}
	public void setBalance(float balance) {
		Balance = balance;
	}
	
	
}
