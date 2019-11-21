package com.skillstorm.nextgen.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAO {
 public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//TODO change connection url
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chinook", "root", "admin ");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e); // TODO Check the exception
		}
 }
 
}
