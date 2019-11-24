package com.skillstorm.nextgen.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skillstorm.nextgen.pojo.User;

public class UserDAO {
	
 public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//TODO change connection URL
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timedopla", "root", "admin");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e); // TODO Check the exception
		}
 }
 
 public User save(User user) {
	 Connection conn = getConnection();
	 
	 try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO USER(FIRSTNAME,LASTNAME,PCODE,ROLEID) VALUES(?,?,?,?)", new String[] { "userId" });
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getGatecode());
			pstmt.setInt(4, user.getRoleAsId());
			
			pstmt.executeUpdate();
			ResultSet keys = pstmt.getGeneratedKeys();
			while (keys.next()) {
				int userId = keys.getInt(1);
				user.setUserId(userId);
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
	 return user;
	 
	 }
 
 
 public User findByUserId(int id) {
	 Connection conn = getConnection();
	 User user = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("select *  from user where  userId=?");
			pstmt.setInt(1, id);
			ResultSet results = pstmt.executeQuery();
			results.next();
		
			String role = getRoleAsString(results.getInt(6));

			user = new User(results.getInt(1), results.getString(2),results.getString(3),results.getString(4),results.getString(5), role);
		} catch (SQLException e) {
			//throw new RuntimeException(e); 
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				//throw new RuntimeException(e);
		
			}
		}
		 System.out.println(user.toString());
		 return user;
	 }

public User findByUserName(String username) {
			 Connection conn = getConnection();
			 User user = null;
				try {
					PreparedStatement pstmt = conn.prepareStatement("select *  from user where  username=?");
					pstmt.setString(1, username);
					ResultSet results = pstmt.executeQuery();
					results.next();
				
					String role = getRoleAsString(results.getInt(6));

					user = new User(results.getInt(1), results.getString(2),results.getString(3),results.getString(4),results.getString(5), role);
				} catch (SQLException e) {
					//throw new RuntimeException(e); 
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						//throw new RuntimeException(e);
				
					}
				}
	 System.out.println(user.toString());
	 return user;
 }
  
public void update(User user) {
		String sql = "update user set firstname = ?,lastname = ?,pcode = ?, roleI d= ?  where userId = ?";
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getGatecode());
			pstmt.setInt(4, user.getRoleAsId());
			pstmt.setInt(5, user.getUserId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				//throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				//throw new RuntimeException(e);
			}
		}
	}
 
 public void delete(int id) {

	 
		String sql = "DELETE FROM USER WHERE USERID = ?";
		Connection conn = getConnection();
		
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
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
				//throw new RuntimeException(e);
			}
		}
	 //
 }
	
 public String getRoleAsString(int rId) {
		String role = "";
		
		switch(rId) {
		case 3: role ="Admin";
		break;
		case 2: role = "Manager";
		break;
		case 1: role = "Standard";
		break;
		}
		
		return role;
		
	}	
}


