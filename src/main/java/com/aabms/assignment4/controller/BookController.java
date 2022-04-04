package com.aabms.assignment4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aabms.assignment4.beans.Book;
import com.aabms.assignment4.dao.BookDao;

/*  Author Bhupesh Gunda, Avinash Kour
 * Date 22-03-2022
 * Description:  contains API calls to save, update and delete a book
 * */

@Controller
public class BookController {
	@Autowired
	BookDao dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/bookform")
	public String showform(Model m) {
		m.addAttribute("command", new Book());
		return "bookform";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/booksave", method = RequestMethod.POST)
	public String save(@ModelAttribute("book") Book book) {
		dao.save(book);
		return "redirect:/viewbook";// will redirect to viewemp request mapping
	}

	// borrow book

	@RequestMapping("/borrowbook")
	public String showborrowbookform(Model m) {
		m.addAttribute("command", new Book());
		return "borrowbook";
	}

	@RequestMapping(value = "/borrowsave", method = RequestMethod.POST)
	public String borrowsave(@ModelAttribute("book") Book book) {
		dao.borrowsave(book);
		return "redirect:/displayborrowbook";// will redirect to viewemp request mapping
	}

	@RequestMapping("/displayborrowbook")
	public String viewdisplayborrowbook(Model m) {
		List<Book> list = dao.getBorrowBooks();
		m.addAttribute("list", list);
		return "displayborrowbook";
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewbook")
	public String viewemp(Model m) {
		List<Book> list = dao.getBooks();
		m.addAttribute("list", list);
		return "viewbook";
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editbook/{bookid}")
	public String edit(@PathVariable String bookid, Model m) {
		Book book = dao.getBookById(Integer.parseInt(bookid));
		m.addAttribute("command", book);
		return "bookeditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book book) {
		try {
			dao.update(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/viewbook";
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deletebook/{bookid}", method = RequestMethod.GET)
	public String delete(@PathVariable int bookid) {
		dao.delete(bookid);
		return "redirect:/viewbook";
	}

	// Borrow Book Edit & Delete

	@RequestMapping(value = "/editissuebook/{issuebookid}")
	public String editIssueBook(@PathVariable int issuebookid, Model m) {
		Book book = dao.getIssueBookById(issuebookid);
		m.addAttribute("command", book);
		return "issuebookeditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editbbsave", method = RequestMethod.POST)
	public String editIssueBooksave(@ModelAttribute("book") Book book) {
		dao.updateIssueBook(book);
		return "redirect:/displayborrowbook";
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteissuebook/{issuebookid}", method = RequestMethod.GET)
	public String deleteIssueBook(@PathVariable int issuebookid) {
		dao.deleteIssueBook(issuebookid);
		return "redirect:/displayborrowbook";
	}

}