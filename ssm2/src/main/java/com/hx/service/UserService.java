package com.hx.service;

import java.util.List;

import com.hx.bean.User;

public interface UserService {
	User getUserById(int id);

	User getUser(int id, int age);
	
	List<User> getAllUsers();
}
