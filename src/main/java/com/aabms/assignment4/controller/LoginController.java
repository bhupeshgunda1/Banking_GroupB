package com.aabms.assignment4.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aabms.assignment4.beans.Accounts;
import com.aabms.assignment4.beans.Customers;
import com.aabms.assignment4.beans.Login;
import com.aabms.assignment4.dao.LoginDao;

/* Author Bhupesh Gunda, Sathish Thimma Reddy
 * Date 22-03-2022
 * Login Controller which validates the user and signs in
 * */
@Controller
public class LoginController {
	@Autowired
	LoginDao dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/registerUser")
	public String adduserform(Model m) {
		m.addAttribute("command", new Login());
		return "registerUser";
	}

	@RequestMapping("/login")
	public String loginuserform(Model m) {
		m.addAttribute("command", new Login());
		return "login";
	}

	@RequestMapping(value = "/addusersave", method = RequestMethod.POST)
	public String addusersave(@Valid @ModelAttribute("login") Login login, Errors errors) {
		System.out.println(login.getUsername().equals(null) || login.getPassword().equals(null));
		if (errors.hasErrors()) {
			return "redirect:/LoginFailed";
		} else {
			dao.save1(login);
			return "redirect:/login"; // will redirect to viewemp request mapping
		}
	}

	// login.............

	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public String logincheck(@Valid @ModelAttribute("login") Login login, Errors errors, Model m) throws SQLException {
		// dao.loginchecking(login);
		String isAdmin = dao.isAdminCheck(login);
		System.out.println("isAdmin = " + isAdmin);

		if (isAdmin.equalsIgnoreCase("Y")) {

			return "redirect:/adminhome";
		}

		if (dao.loginchecking(login)) {

			m.addAttribute("username", login.getUsername());
			m.addAttribute("sbalance", login.getUsername());
			m.addAttribute("cbalance", login.getUsername());
			return "redirect:/home";
		}

		else {
			return "redirect:/LoginFailed";
		}
	}

	@RequestMapping(value = "/customerLoginCheck", method = RequestMethod.POST)
	public String customerLoginCheck(@Valid @ModelAttribute("Customers") Customers customers, Errors errors, Model m)
			throws SQLException {
		// dao.loginchecking(login);
		Customers customer = dao.customerLoginCheck(customers);
		if (customer != null) {
			System.out.println("isAdmin = " + customer.getIsAdmin());

			if (customer.getIsAdmin().equalsIgnoreCase("Y")) {
				return "redirect:/adminhome";
			}
			Float balance =dao.getBalance(customer.getCust_ID());
			if(balance!=0 && balance>0.0)
			{
				//m.addAttribute("",customer))
				m.addAttribute("username", customer.getF_name() + ", " +customer.getL_name());
				m.addAttribute("sbalance", balance);
				m.addAttribute("custid", customer.getCust_ID());
				//m.addAttribute("cbalance", customers.getUsername());
			}
			return "redirect:/home";
		} else {
			return "redirect:/LoginFailed";
		}
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewuser")
	public String viewuser(Model m) {
		List<Login> list = dao.getUsers();
		m.addAttribute("list", list);
		return "viewuser";
	}

	// home
	@RequestMapping("/home")
	public String home(Model m) {
		m.addAttribute("command", new Login());
		return "home";
	}

	@RequestMapping("/adminhome")
	public String adminhome(Model m) {
		m.addAttribute("command", new Login());
		return "adminhome";
	}

	// login failed
	@RequestMapping("/LoginFailed")
	public String LoginFailed(Model m) {
		m.addAttribute("command", new Login());
		return "LoginFailed";
	}

	// Edit and Delete User

	@RequestMapping(value = "/edituser/{loginid}")
	public String edit1(@PathVariable int loginid, Model m) {
		Login login = dao.getUserById(loginid);
		m.addAttribute("command", login);
		return "usereditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editusave", method = RequestMethod.POST)
	public String editsave1(@ModelAttribute("member") Login login) {
		dao.update1(login);
		return "redirect:/viewuser";
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteuser/{loginid}", method = RequestMethod.GET)
	public String delete1(@PathVariable int loginid) {
		dao.delete1(loginid);
		return "redirect:/viewuser";
	}
	
	
	
	@RequestMapping(value = "/depositMoney", method = RequestMethod.POST)
	public String depositMoney(@Valid @ModelAttribute("Accounts") Accounts acc, Errors errors, Model m)
			throws SQLException {
		// dao.loginchecking(login);
		dao.depositMoney(acc);
		Float balance = dao.getBalance(acc.getCust_ID());
		
		if ( balance != null && balance>0.0)
		{
				m.addAttribute("sbalance", balance);
				//m.addAttribute("cbalance", customers.getUsername());
		}
		else
		{
			m.addAttribute("sbalance", 0.0);
		}
		return "redirect:/home";
	}
}
