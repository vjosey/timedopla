package com.skillstorm.nextgen.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.nextgen.pojo.PunchCard;
import com.skillstorm.nextgen.pojo.Timesheet;
import com.skillstorm.nextgen.serv.PunchCardService;


public class TimeSheetDAO {
	
	PunchCardService pcService = new PunchCardService();
	
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
				
				LinkedList<PunchCard> pcList = pcService.findPCardsByTimesheetId(rs.getInt("tsheetId"));
				
				// Change to set by day (to the most recent date)  
				
				 for(PunchCard p : pcList )
				 {
					 p.CalculateHours();
				 }
				 
				if(pcList.size() != 0)
				{
				results.setSunPcard(pcList.get(0));
				results.setMonPcard(pcList.size()>= 2 ? pcList.get(1) : new PunchCard());
				results.setTuePcard(pcList.size()>= 3? pcList.get(2) : new PunchCard());
				results.setWedPcard(pcList.size()>= 4 ? pcList.get(3) : new PunchCard());
				results.setThurPcard(pcList.size()>= 5 ? pcList.get(4) : new PunchCard());
				results.setFriPcard(pcList.size()>= 6? pcList.get(5) : new PunchCard());
				results.setSatPcard(pcList.size()>= 7 ? pcList.get(6) : new PunchCard());
				}
			
				results.CalculateHours();
				System.out.println(results);
				
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
		 
			String sql = "update timesheet set tsStatus = ? where tsheetId = ?";
			Connection conn = getConnection();
			try {
				conn.setAutoCommit(false);
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(2, timesheet.getTimesheetId());
				stmt.setInt(1, timesheet.getTsStatus());
				stmt.executeUpdate();
				conn.commit();
			} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					throw new RuntimeException(e1);
				}
				throw new RuntimeException(e);
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}			
	 }
	 
	 public void delect(int id) {
			String sql = "DELETE FROM TIMESHEET WHERE TIMESHEETID = ?";
			Connection conn = getConnection();
	 }
	 
		 
}
