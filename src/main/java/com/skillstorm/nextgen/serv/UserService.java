package com.skillstorm.nextgen.serv;

import com.skillstorm.nextgen.data.UserDAO;
import com.skillstorm.nextgen.pojo.User;

public class UserService {

	private UserDAO userDAO = new UserDAO();
	
	public User save(User user) {
		userDAO.save(user);
		return user;
	}
	
	
	public User findByUserId(int id) {
		return userDAO.findByUserId(id);
	}


	public User findAll() {
		// TODO Add code for find all users 
		return null;
	}

	public User findByUserName(String username) {
		return userDAO.findByUserName(username);
	}

}
