package com.hx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.hx.bean.User;
import com.hx.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController2 extends AbstractController {
	
	@Resource
	private UserService userService;

	@Override
	@RequestMapping("/getUser")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(id);
		return new ModelAndView("showUser", "user", user);
	}
	
}
