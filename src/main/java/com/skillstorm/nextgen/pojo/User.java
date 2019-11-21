package com.skillstorm.nextgen.pojo;

import java.util.LinkedList;

public class User {
	
	private int userId;
	private String firstName;
	private String lastName;
	private String userRole;
	private String userStatus;
	private String userInitials;
	private LinkedList<Timesheet> timeSheet;
	
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

	
	
	
	public String generateUserInitial() {
		
		// TODO use first name and last name to generate initial
		
		return "VJ"; // TODO change return
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userRole="
				+ userRole + ", userStatus=" + userStatus + ", userInitials=" + userInitials + "]";
	}


	
	
	
	
}
