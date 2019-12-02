package com.skillstorm.nextgen.serv;

import java.util.LinkedList;

import com.skillstorm.nextgen.data.PunchCardDAO;
import com.skillstorm.nextgen.pojo.PunchCard;

public class PunchCardService {
	
	PunchCardDAO pcardDAO = new PunchCardDAO();
	
	
	 public LinkedList<PunchCard> findPCardsByTimesheetId(int id) {
		 
		 return pcardDAO.findPCardsByTimesheetId(id);
	 }
	 
	 
	 public PunchCard findByPCardId(int id) {
		 return pcardDAO.findByPCardId(id);
	 }
	
	
	

}
