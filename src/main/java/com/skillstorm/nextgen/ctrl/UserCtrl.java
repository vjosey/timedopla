package com.skillstorm.nextgen.ctrl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

	public void getUser(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	public void postUser(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

}
