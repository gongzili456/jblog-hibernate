package org.jblog.controller;

import javax.servlet.http.HttpSession;

import org.jblog.domain.User;
import org.jblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@RequestParam Long id, Model model,HttpSession session) {
		User user = userService.get(id);
		//model.addAttribute("user", user);
		//model.addAttribute("aName", "asss");
		
		session.setAttribute("user", user);
		return "login";
	}

}
