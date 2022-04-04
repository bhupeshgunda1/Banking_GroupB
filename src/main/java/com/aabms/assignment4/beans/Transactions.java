package com.aabms.assignment4.beans;

import java.sql.Date;

public class Transactions {

	private String Tran_ID;
	private float amount;
	private int Account_number;
	private Date tran_date;
	public String getTran_ID() {
		return Tran_ID;
	}
	public void setTran_ID(String tran_ID) {
		Tran_ID = tran_ID;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getAccount_number() {
		return Account_number;
	}
	public void setAccount_number(int account_number) {
		Account_number = account_number;
	}
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}
	
}
