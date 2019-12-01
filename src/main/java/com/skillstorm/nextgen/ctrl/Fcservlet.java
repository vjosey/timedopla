package com.skillstorm.nextgen.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Fcservlet extends HttpServlet {

	private UserCtrl userController = new UserCtrl();
	private TimeSheetCtrl timeSheetController = new TimeSheetCtrl();
	private PunchCardCtrl punchCardController = new PunchCardCtrl();
	private SessionCtrl sessionController = new SessionCtrl();

	protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		switch (uri) {
		case "/Timedopla/api/user":
			if (req.getMethod().equals("POST")) {
				userController.postUser(req, resp);
				return;
			}
			if (req.getMethod().equals("PUT")) {
				userController.getUser(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				userController.getUser(req, resp);
				return;
			}
			if (req.getMethod().equals("DELETE")) {
				userController.deleteUser(req, resp);
				return;
			}
			
			break;
			
		case "/Timedopla/api/timesheet":
			if (req.getMethod().equals("POST")) {
				timeSheetController.postTimeSheet(req, resp);
				return;
			}
			if (req.getMethod().equals("PUT")) {
				timeSheetController.getTimeSheet(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				timeSheetController.getTimeSheet(req, resp);
				return;
			}
			if (req.getMethod().equals("DELETE")) {
				timeSheetController.deleteTimeSheet(req, resp);
				return;
			}
			
			break;
			
		case "/Timedopla/api/punchcard":
			if (req.getMethod().equals("POST")) {
				punchCardController.postPunchCard(req, resp);
				return;
			}
			if (req.getMethod().equals("PUT")) {
				punchCardController.getPunchCard(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				punchCardController.getPunchCard(req, resp);
				return;
			}
			if (req.getMethod().equals("DELETE")) {
				punchCardController.deletePunchCard(req, resp);
				return;
			}
			
			break;
			
		case "/Timedopla/api/session":
			if (req.getMethod().equals("POST")) {
				sessionController.postUser(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				sessionController.getUser(req, resp);
				return;
			}
			if (req.getMethod().equals("DELETE")) {
				userController.deleteUser(req, resp);
				return;
			}
			
			break;

		default:
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println(" FC Initialized!");
	}
	

}
