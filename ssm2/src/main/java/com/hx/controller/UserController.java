package com.hx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hx.bean.User;
import com.hx.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	public void action() {
		User user = userService.getUserById(1);
		System.out.println(user.getUsername());
	}
	
	@RequestMapping("/showUser")
	public String showUser(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(id);
		model.addAttribute("user",user);
		return "showUser";
	}
	
	@RequestMapping("/showUser2")
	public String showUser2(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		int age = Integer.parseInt(request.getParameter("age"));
		User user = userService.getUser(id, age);
		model.addAttribute("user",user);
		return "showUser";
	}
}
