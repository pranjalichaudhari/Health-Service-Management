package com.cg.hsm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.domain.User;
import com.cg.hsm.exception.UserNameException;
import com.cg.hsm.repository.UserRepository;
import com.cg.hsm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	String adminUsername = "hsmgroup4";
	String adminPassword = "hsmgroup4";
	 
	// Adding user details into the table
	@Override
	public User saveUser(User user) {
		try {
			user.setUserName(user.getUserName().toUpperCase());
			return userRepository.save(user);
		} catch (Exception e) {
			throw new UserNameException("User Name : " + user.getUserName().toUpperCase() + " already exists");
		}

	}

	// Finding user details using userName
	@Override
	public User findByUserName(String userName) {
		User user = userRepository.findByUserName(userName.toUpperCase());
		if (user == null) 
		{
			throw new UserNameException("User Name : " + userName.toUpperCase() + " does not exists");
		}
		return user;
	}

	// Finding all users
	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Deleting a user based on userName
	@Override
	public void deleteByUserName(String userName) {
		User user = userRepository.findByUserName(userName.toUpperCase());
		if (user == null) {
			throw new UserNameException("User Name : " + userName.toUpperCase() + " does not exists");
		}
		userRepository.delete(user);
	}

	// Updating user password
	@Override
	public void updateUserPassword( User user,String userName)
	{
		userRepository.save(user);
	}
	
	//Authenticating the user
	@Override
	public String authenticateUser(User user)
	{
		User user1 = userRepository.findByUserName(user.getUserName().toUpperCase());
		if (user1 == null) 
		{
			throw new UserNameException("User Name : " + user.getUserName().toUpperCase() + " does not exists");
		}
		if(user1.getUserPassword().equalsIgnoreCase(user.getUserPassword()))
		{
			return "Entry granted";
		}
		else
		{
			return "please enter valid credentials";
		}
	}
   
     
	@Override
	public String authenticateAdmin(User user) {
		if(user.getUserName().equalsIgnoreCase(adminUsername) && user.getUserPassword().equalsIgnoreCase(adminPassword) )
		{
			return "Entry granted";
		}
		else
		{
			return "Please provide correct credentials";
		}
	}

}