package com.skillstorm.nextgen.ctrl;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutCtrl {

	
	public void getSession(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException, IOException {
		
		resp.setContentType("application/json");
		req.getSession().invalidate();
		System.out.println("Out");
		resp.setStatus(201);
	}

	
}
