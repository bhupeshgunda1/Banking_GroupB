package com.aabms.assignment4.beans;

import java.util.Date;

public class Utilities {
	
	private String Biller_ID;
	private String Biller_Name;
	private String Cust_ID;
	private Date Bill_date;
	
	public String getBiller_ID() {
		return Biller_ID;
	}
	public void setBiller_ID(String biller_ID) {
		Biller_ID = biller_ID;
	}
	public String getBiller_Name() {
		return Biller_Name;
	}
	public void setBiller_Name(String biller_Name) {
		Biller_Name = biller_Name;
	}
	public String getCust_ID() {
		return Cust_ID;
	}
	public void setCust_ID(String cust_ID) {
		Cust_ID = cust_ID;
	}
	public Date getBill_date() {
		return Bill_date;
	}
	public void setBill_date(Date bill_date) {
		Bill_date = bill_date;
	}
	
	
}
