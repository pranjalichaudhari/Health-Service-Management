package com.cg.hsm.service;

import com.cg.hsm.domain.User;

public interface UserService 
{
	User saveUser(User user);
	User findByUserName(String userName);
	Iterable<User> getAllUsers();
	void deleteByUserName(String userName);
	void updateUserPassword(User user,String userName);
	String authenticateUser(User user);
	String authenticateAdmin(User user);
}