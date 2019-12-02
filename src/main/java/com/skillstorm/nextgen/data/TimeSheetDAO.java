package com.skillstorm.nextgen.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.nextgen.pojo.Timesheet;


public class TimeSheetDAO {
	
	 public Connection getConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timedopla", "root", "admin");
				return conn;
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e); 
			}
	 }
	 
	 
	 public LinkedList<Timesheet> findTimesheetsByUserId(int id) {
		 
		 Connection conn = getConnection();
		 LinkedList<Timesheet> results = new LinkedList<>();
	
			try {
				
				PreparedStatement pstmt = conn.prepareStatement("select * from timesheet where userId=?");
				pstmt.setInt(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					
					System.out.println(rs.getInt("tsheetId"));
					Timesheet ts = new Timesheet(rs.getInt("tsheetId"), rs.getInt("userId"), rs.getDate("startWeek").toString(), rs.getInt("tsStatus"));
					
					ts.getStatusAsString();
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
	 
	 public Timesheet findByTimesheetId(int id) {
		 
		 Connection conn = getConnection();
		 Timesheet results = new Timesheet();
		 
			try {
				
				PreparedStatement pstmt = conn.prepareStatement("select * from timesheet where tsheetId=?");
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				
				rs.next();
				results = new Timesheet(rs.getInt("tsheetId"), rs.getInt("userId"), rs.getDate("startWeek").toString(), rs.getInt("tsStatus"));
				results.getStatusAsString();
				
				//System.out.println(ts);
				
			} catch (SQLException e) {
				//throw new RuntimeException(e); 
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					//throw new RuntimeException(e);
				}
		}
		 
		 return results;
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
