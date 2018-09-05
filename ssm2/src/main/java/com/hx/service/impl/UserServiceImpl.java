package com.hx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hx.bean.User;
import com.hx.dao.UserDao;
import com.hx.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public User getUserById(int id) {
		User user = userDao.getUserById(id);
		return user;
	}

	@Override
	public User getUser(int id, int age) {
		User user = userDao.getUser(id, age);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		return users;
	}

}
