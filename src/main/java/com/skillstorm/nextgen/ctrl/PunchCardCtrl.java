package com.skillstorm.nextgen.ctrl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.nextgen.serv.PunchCardService;

public class PunchCardCtrl {

	PunchCardService pCardService = new PunchCardService();
	
	public void postPunchCard(HttpServletRequest req, HttpServletResponse resp) {
		
		
	}

	public void getPunchCard(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException, JsonProcessingException, IOException {
		resp.setContentType("application/json");
		
		if(req.getParameter("tsId") != null)
		{
			
		 resp.getWriter().println(new ObjectMapper().writeValueAsString(pCardService.findPCardsByTimesheetId(Integer.parseInt(req.getParameter("tsId")))));
		}else if(req.getParameter("id") != null)
		{
		 resp.getWriter().println(new ObjectMapper().writeValueAsString(pCardService.findByPCardId(Integer.parseInt(req.getParameter("id")))));
		}
		
	}

	public void deletePunchCard(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

}
