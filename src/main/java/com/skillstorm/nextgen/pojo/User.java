package com.skillstorm.nextgen.pojo;

import java.util.LinkedList;

public class User {
	
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String userRole;
	private String userStatus;
	private String userInitials;
	private LinkedList<Timesheet> timeSheet;
	private String gatecode; // password
	
	

	public User(int userId, String firstName, String lastName, String userRole, String userStatus, String userInitials,
			LinkedList<Timesheet> timeSheet, String gatecode) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
		this.userStatus = userStatus; // TODO do not need this user status. remove later
		this.userInitials = userInitials;
		this.timeSheet = timeSheet;
		this.gatecode = gatecode;
		
		if(firstName != null && lastName != null)
		{
			this.userInitials = generateUserInitial();
		}
	}

	public User(int userId, String firstName, String lastName, String userRole) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
		
		if(firstName != null && lastName != null)
		{
			this.userInitials = generateUserInitial();
		}
	}
	
	
	public User(int userId, String userName, String firstName, String lastName, String gatecode, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRole = userRole;
		this.gatecode = gatecode;
		
		
		if(firstName != null && lastName != null)
		{
			this.userInitials = generateUserInitial();
		}
	}

	// Converting  role string into role id
	public int getRoleAsId() {
		int rId = 0;
		switch(userRole) {
		case "Admin": rId = 3;
		break;
		case "Manager": rId = 2;
		break;
		case "Standard" : rId = 1;
		break;
		}
		
		return rId;
		
	}
	
	//TODO this method should be replace data query
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserInitials() {
		return userInitials;
	}

	public void setUserInitials(String userInitials) {
		this.userInitials = userInitials;
	}

	public LinkedList<Timesheet> getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(LinkedList<Timesheet> timeSheet) {
		this.timeSheet = timeSheet;
	}

	
	public String getGatecode() {
		return gatecode;
	}

	public void setGatecode(String gatecode) {
		this.gatecode = gatecode;
	}
	
	
	
	public String generateUserInitial() {
		
		//  use first name and last name to generate initial
		
		StringBuilder initial = new StringBuilder();
		char fLetter = this.firstName.charAt(0);
		char lLetter = this.lastName.charAt(0);
		initial.append(fLetter).append(lLetter);
		
		return initial.toString();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userRole=" + userRole + ", userStatus=" + userStatus + ", userInitials=" + userInitials
				+ ", timeSheet=" + timeSheet + ", gatecode=" + gatecode + "]";
	}
	
	
	


	
	
	
	
}
