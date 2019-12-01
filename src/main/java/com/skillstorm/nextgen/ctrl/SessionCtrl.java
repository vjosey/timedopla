package com.skillstorm.nextgen.ctrl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.nextgen.pojo.User;
import com.skillstorm.nextgen.serv.UserService;

public class SessionCtrl {
	
	private UserService userService = new UserService();
	
	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException, IOException {
		// TODO getUser(req,resp)
		
		resp.setContentType("application/json");
		
		//check username and password
		
		
		//if user and password exsist the create a session
		
		if (req.getParameter("name") != null) {
		
			
			User userProfile = userService.findByUserName(req.getParameter("username"));
			
			if (userProfile != null) {
				if(userProfile.getGatecode() == req.getParameter("password")) {
					
					
				}else {
					
					//can not login
				}
			}
		}
		
		
		resp.setStatus(201);
	}

	
	public void postUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		
		//check username and password
		//if user and password exist the create a session
		User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
		
		User userProfile = userService.findByUserName(user.getUserName());
			
			System.out.println(userProfile.getFirstName());
			
			if (userProfile.getGatecode().equals(user.getGatecode()))
			{
				
					HttpSession session = req.getSession();
					session.setAttribute("user", userProfile);
         			//System.out.println(session.getAttribute("user"));
 
			}else{
				//user cannot login
				resp.getWriter().println("#noaccess");
				System.out.println("wrong username or password");
			}
		
		
		//System.out.println();
		resp.setStatus(201);
		
	}

}
