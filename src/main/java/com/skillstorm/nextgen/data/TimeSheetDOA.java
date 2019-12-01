package com.skillstorm.nextgen.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.nextgen.pojo.Timesheet;
import com.skillstorm.nextgen.pojo.User;

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
	 
	 
	 public List<Timesheet> findByTimesheetsId(int id) {
		 
		 Connection conn = getConnection();
		 
		 LinkedList<Timesheet> results = new LinkedList<>();
		
			try {
				PreparedStatement pstmt = conn.prepareStatement("select *  from timesheet where  userId=?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Timesheet ts = new Timesheet(rs.getInt("tsheetId"), rs.getInt("userId"), rs.getString("startDate"), rs.getInt("tsStatus"));
					results.add(ts);
				}
				
			} catch (SQLException e) {
				//throw new RuntimeException(e); 
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					//throw new RuntimeException(e);
			
				}
			}
			// System.out.println(user.toString());
		 
		 return results;
	 }
	 
	 public Timesheet findByUserId(Timesheet timesheet) {
		 
		 return timesheet;
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
