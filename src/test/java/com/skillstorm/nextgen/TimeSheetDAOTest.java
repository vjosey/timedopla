package com.skillstorm.nextgen;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import com.skillstorm.nextgen.data.TimeSheetDAO;
import com.skillstorm.nextgen.pojo.Timesheet;

public class TimeSheetDAOTest {
	
	@Test
	 public void  findTimesheetsByUserId() {
		
		TimeSheetDAO dao = new TimeSheetDAO();
		
		LinkedList<Timesheet> tsList = dao.findTimesheetsByUserId(6);
		
	
		String actuals= Integer.toString(tsList.size());
		
		String expecteds = "6";
		
		System.out.println(actuals);
		 Assert.assertEquals(expecteds, actuals);
		
	}
	 
	
	
	@Test
	 public void  findByTimesheetId() {
		
		TimeSheetDAO dao = new TimeSheetDAO();
		
		Timesheet ts = dao.findByTimesheetId(6);
		
	
		int actuals = ts.getTimesheetId();
		
		int expecteds = 6;
		
		//System.out.println("Test " + actuals + " --- " + ts.getTimesheetId() );
		 Assert.assertEquals(expecteds, actuals);
		
	}
	 
	 
	 
	
	

}
