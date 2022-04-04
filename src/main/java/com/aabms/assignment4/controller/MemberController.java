package com.aabms.assignment4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aabms.assignment4.beans.Member;
import com.aabms.assignment4.dao.MemberDao;

/*
 * Date 22-03-2022
 * 
 * */
@Controller
public class MemberController {
	@Autowired
	MemberDao dao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/memberform")
	public String memberform(Model m) {
		m.addAttribute("command", new Member());
		return "memberform";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/membersave", method = RequestMethod.POST)
	public String membersave(@ModelAttribute("member") Member member) {
		dao.save1(member);
		return "redirect:/viewmember";// will redirect to viewemp request mapping
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewmember")
	public String viewmember(Model m) {
		List<Member> list = dao.getMembers();
		m.addAttribute("list", list);
		return "viewmember";
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editmember/{membid}")
	public String edit1(@PathVariable int membid, Model m) {
		Member member = dao.getMemberById(membid);
		m.addAttribute("command", member);
		return "membereditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editmsave", method = RequestMethod.POST)
	public String editsave1(@ModelAttribute("member") Member member) {
		dao.update1(member);
		return "redirect:/viewmember";
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deletemember/{membid}", method = RequestMethod.GET)
	public String delete1(@PathVariable int membid) {
		dao.delete1(membid);
		return "redirect:/viewmember";
	}
}