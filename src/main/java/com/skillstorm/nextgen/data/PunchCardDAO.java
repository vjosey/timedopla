package com.skillstorm.nextgen.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.skillstorm.nextgen.pojo.PunchCard;
import com.skillstorm.nextgen.pojo.Timesheet;

public class PunchCardDAO {
	
	 public Connection getConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timedopla", "root", "admin");
				return conn;
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e); 
			}
	 }
	
	
	 
	 public LinkedList<PunchCard> findPCardsByTimesheetId(int id) {
		 Connection conn = getConnection();
		
		 LinkedList<PunchCard> pcardList = new LinkedList<>(); 
		 
			try {
				
				PreparedStatement pstmt = conn.prepareStatement("select * from punchcard where timesheetId=?");
				pstmt.setInt(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					
					PunchCard pc = new PunchCard(rs.getInt("pcardId"), rs.getLong("amIn"),rs.getInt("amOut"),rs.getInt("pmIn"),rs.getInt("pmOut"));
					System.out.println(rs.getInt("pcardId"));
	
					pcardList.add(pc);
				}
				
			} catch (SQLException e) {
				//throw new RuntimeException(e); 
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					//throw new RuntimeException(e);
				}}
		 
		 return pcardList;
	 }
	 
	 
	 public PunchCard findByPCardId(int id) {
		 Connection conn = getConnection();
		 PunchCard pcard = null;
		try {
				
				PreparedStatement pstmt = conn.prepareStatement("select * from punchcard where timesheetId=?");
				pstmt.setInt(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				rs.next();
			
				pcard = new PunchCard(rs.getInt("pcardId"), rs.getLong("amIn"),rs.getInt("amOut"),rs.getInt("pmIn"),rs.getInt("pmOut"));
				System.out.println(rs.getInt("pcardId"));
	
			} catch (SQLException e) {
				//throw new RuntimeException(e); 
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					//throw new RuntimeException(e);
				}}
		 return pcard;
	 }
}
