package com.skillstorm.nextgen.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.skillstorm.nextgen.pojo.Timesheet;

public class TimeSheetDOA {
	
	 public Connection getConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				//TODO change connection url
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timedopla", "root", "admin");
				return conn;
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e); // TODO Check the exception
			}
	 }
	 
	 
	 
	 
	 public Timesheet save(Timesheet timesheet) {
		 
		 return timesheet;
	 }
	 
	 
	 public void update(Timesheet timesheet) {

			
	 }
	 
	 public void delect(int id) {
			String sql = "DELETE FROM TIMESHEET WHERE TIMESHEETID = ?";
			Connection conn = getConnection();
	 }
	 
	 public void delectByUser(int id, int userId) {
			String sql = "DELETE FROM TIMESHEET WHERE TIMESHEETID = ?";
			Connection conn = getConnection();
	 }
	 
	 
}
