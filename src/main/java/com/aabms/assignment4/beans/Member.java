package com.aabms.assignment4.beans;

public class Member {

	private int membid;
	private String name;
	private String address;
	private String membtype;
	private String membdate;
	private String expdate;
	private int loginid;

	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public int getMembid() {
		return membid;
	}

	public void setMembid(int membid) {
		this.membid = membid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMembtype() {
		return membtype;
	}

	public void setMembtype(String membtype) {
		this.membtype = membtype;
	}

	public String getMembdate() {
		return membdate;
	}

	public void setMembdate(String membdate) {
		this.membdate = membdate;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

}
