package com.skillstorm.nextgen.serv;

import java.util.LinkedList;

import com.skillstorm.nextgen.data.TimeSheetDAO;
import com.skillstorm.nextgen.pojo.Timesheet;

public class TimeSheetService {
	
	TimeSheetDAO tsDAO = new TimeSheetDAO();
	
	 public LinkedList<Timesheet> findTimesheetsByUserId(int id) 
	 {
		 return tsDAO.findTimesheetsByUserId(id);
	 }
	 
	 public Timesheet findTimesheetById(int id)
	 {
		 return tsDAO.findByTimesheetId(id);
	 } 
	 
	 
	 public void update(Timesheet timesheet)
	 {
		 tsDAO.update(timesheet);
	 }

}
