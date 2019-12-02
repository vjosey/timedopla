package com.skillstorm.nextgen.ctrl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.nextgen.pojo.User;
import com.skillstorm.nextgen.serv.TimeSheetService;



public class TimeSheetCtrl {

	
	TimeSheetService timesheetService = new TimeSheetService();
	
	
	public void postTimeSheet(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	public void getTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws JsonProcessingException, IOException {

		resp.setContentType("application/json");
		
		HttpSession session = req.getSession(); 
		
		User user = (User) session.getAttribute("user");
		
		if(user != null) 
		{
			
			if(req.getParameter("ID") != null)
			{
				resp.getWriter().println(new ObjectMapper().writeValueAsString(timesheetService.findTimesheetsByUserId(user.getUserId())));
			}else
			{
			resp.getWriter().println(new ObjectMapper().writeValueAsString(timesheetService.findTimesheetsByUserId(user.getUserId())));
			}
			//session.setAttribute("timesheets", );
		}else {
			System.out.println("No user session found!");
		}
	}

	public void deleteTimeSheet(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

}
