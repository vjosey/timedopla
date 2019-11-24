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

}
