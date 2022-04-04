package com.aabms.assignment4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aabms.assignment4.beans.Publisher;
import com.aabms.assignment4.dao.PublisherDao;

/* @Author - Manvir Singh Sodhi, 
 * Date 22-03-2022
 * 
 * */
@Controller
public class PublisherController {
	@Autowired
	PublisherDao dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/publisherform")
	public String publisherform(Model m) {
		m.addAttribute("command", new Publisher());
		return "publisherform";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/publishersave", method = RequestMethod.POST)
	public String publishersave(@ModelAttribute("publisher") Publisher publisher) {
		dao.save1(publisher);
		return "redirect:/viewpublisher";// will redirect to viewemp request mapping
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewpublisher")
	public String viewpublisher(Model m) {
		List<Publisher> list = dao.getPublishers();
		m.addAttribute("list", list);
		return "viewpublisher";
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editpublisher/{publisherid}")
	public String edit1(@PathVariable int publisherid, Model m) {
		Publisher publisher = dao.getPublisherById(publisherid);
		m.addAttribute("command", publisher);
		return "publishereditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editpsave", method = RequestMethod.POST)
	public String editsave1(@ModelAttribute("publisher") Publisher publisher) {
		dao.update1(publisher);
		return "redirect:/viewpublisher";
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deletepublisher/{publisherid}", method = RequestMethod.GET)
	public String delete1(@PathVariable int publisherid) {
		dao.delete1(publisherid);
		return "redirect:/viewpublisher";
	}
}