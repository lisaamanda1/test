package com.hx.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.hx.bean.BasePR;
import com.hx.bean.User;
import com.hx.service.UserService;
import com.hx.utils.DatagridTool;

@RestController
@RequestMapping("/user")
public class UserController3 {
	@Resource
	private UserService userService;
	
	@RequestMapping("/test")
	public String test(BasePR pr, Model model) {
		System.out.println("------------------∑√Œ µΩ¡À-----------------------");
		System.out.println("------------page:" + pr.getPage());
		System.out.println("------------row:" + pr.getRow());
		List<User> users = userService.getAllUsers();
		String json = DatagridTool.listToJson(users);
		return json;
	}
	
	@RequestMapping(value = "/getAllUsers", produces = "application/json;charset=UTF-8")
	public String getAllUsers(HttpServletRequest request, Model model) {
		List<User> users = userService.getAllUsers();
		String json = DatagridTool.listToJson(users);
		System.out.println(json);
		return json;
	}
}
