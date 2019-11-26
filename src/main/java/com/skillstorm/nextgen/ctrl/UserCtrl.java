package com.skillstorm.nextgen.ctrl;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.nextgen.serv.UserService;

public class UserCtrl {

	private UserService userService = new UserService();
	
	public void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json");
		//resp.getWriter().println(new ObjectMapper().writeValueAsString(userService.save(new ObjectMapper().readValue(req.getInputStream(), User.class))));

		resp.setStatus(201);
		
	}

	public void getUser(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException, JsonProcessingException, IOException {
		// TODO getUser(req,resp)
		
		resp.setContentType("application/json");
		if (req.getParameter(" id") != null) {
			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(userService.findByUserId(Integer.parseInt(req.getParameter("userid")))));
		} else if (req.getParameter("name") != null) {
			resp.getWriter().println(
					new ObjectMapper().writeValueAsString(userService.findByUserName(req.getParameter("username"))));
		} else {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(userService.findAll()));
		}
		resp.setStatus(201);
	}

	public void postUser(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	
	public void putUser(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

}
