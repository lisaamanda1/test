package com.hx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hx.bean.User;

public interface UserDao {
	User getUserById(int id);

	User getUser(@Param("id")int id, @Param("age")int age);
	
	@Select("SELECT * FROM t_user")
	List<User> getAllUsers();
}
