package com.skillstorm.nextgen.ctrl;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.nextgen.pojo.User;
import com.skillstorm.nextgen.serv.UserService;

public class UserCtrl {

	private UserService userService = new UserService();
	
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json");
		//resp.getWriter().println(new ObjectMapper().writeValueAsString(userService.save(new ObjectMapper().readValue(req.getInputStream(), User.class))));

		resp.setStatus(201);
		
	}

	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException, JsonProcessingException, IOException {
		
		resp.setContentType("application/json");
		
		HttpSession session = req.getSession(); 
		
		User user = (User) session.getAttribute("user");
		
	     if (user != null) 
	     {
			resp.getWriter().println(
					new ObjectMapper().writeValueAsString(userService.findByUserId(user.getUserId())));
		} else {
			System.out.println("No user session found!");
		}
		resp.setStatus(201);
	}

	public void postUser(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	
}
