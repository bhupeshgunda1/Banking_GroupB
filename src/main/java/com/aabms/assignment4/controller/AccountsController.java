package com.aabms.assignment4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aabms.assignment4.beans.Accounts;
import com.aabms.assignment4.beans.Customers;
import com.aabms.assignment4.dao.AccountsDao;


/* Author Bhupesh Gunda, Sathish Thimma Reddy
 * Date 22-03-2022
 * Login Controller which validates the user and signs in
 * */

@Controller
public class AccountsController {
	@Autowired
	AccountsDao dao;// will inject dao from xml file
	

	@RequestMapping("/depform")
	public String showDepositForm(Model m) {
		m.addAttribute("command", new Accounts());
		return "deposit";
	}
	
	@RequestMapping("/deposit")
	public String depositAmount(Model m) {
		m.addAttribute("command", new Accounts());
		
		System.out.println("depositAmount method");
		
		Accounts account;
		
		float balance = account.getBalance();
		dao.getClass();
		
		return "home";
	}
}
