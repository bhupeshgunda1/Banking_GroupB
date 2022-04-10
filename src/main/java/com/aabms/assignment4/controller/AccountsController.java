package com.aabms.assignment4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aabms.assignment4.dao.AccountsDao;



/* Author Bhupesh Gunda, Sathish Thimma Reddy
 * Date 22-03-2022
 * Login Controller which validates the user and signs in
 * */

@Controller
public class AccountsController {
	@Autowired
	AccountsDao dao;// will inject dao from xml file
	
}
