package com.skillstorm.nextgen.serv;

import java.util.List;

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


	public List<User> findAll() {
		return userDAO.findAll();
	}

	public User findByUserName(String username) {
		return userDAO.findByUserName(username);
	}

}
