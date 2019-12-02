package com.skillstorm.nextgen.pojo;

public class Timesheet {
	private int timesheetId;
	private int userId;
	private String startOfWeek;
	private int tsStatus;
	private PunchCard monPcard;
	private PunchCard tuePcard;
	private PunchCard wedPcard;
	private PunchCard thurPcard;
	private PunchCard friPcard;
	private PunchCard satPcard;
	private PunchCard sunPcard;
	
	private int totalHours = 40;
	private String status;
	
	
	public Timesheet() {
		super();
	}
	
	
	public Timesheet(int timesheetId, String startOfWeek) {
		super();
		this.timesheetId = timesheetId;
		this.startOfWeek = startOfWeek;
	}




	public Timesheet(int timesheetId, int userId, String startOfWeek, int tsStatus) {
		super();
		this.timesheetId = timesheetId;
		this.userId = userId;
		this.startOfWeek = startOfWeek;
		this.tsStatus = tsStatus;
	}


	public int getHours(PunchCard p_card) {
		// TODO calculate the hours from p_card times
		return 1;
	}

	public void getStatusAsString() {
		String status = "";
		
		switch(tsStatus) {
		case 4: status ="Denied";
		break;
		case 3: status ="Approved";
		break;
		case 2: status = "Submitted";
		break;
		case 1: status = "Saved";
		break;
		}
		
		this.status = status;	
	}
	
	
	
	public int getTimesheetId() {
		return timesheetId;
	}


	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
	}


	public String getStartOfWeek() {
		return startOfWeek;
	}


	public void setStartOfWeek(String startOfWeek) {
		this.startOfWeek = startOfWeek;
	}


	public PunchCard getMonPcard() {
		return monPcard;
	}


	public void setMonPcard(PunchCard monPcard) {
		this.monPcard = monPcard;
	}


	public PunchCard getTuePcard() {
		return tuePcard;
	}


	public void setTuePcard(PunchCard tuePcard) {
		this.tuePcard = tuePcard;
	}


	public PunchCard getWenPcard() {
		return wedPcard;
	}


	public void setWenPcard(PunchCard wenPcard) {
		this.wedPcard = wenPcard;
	}


	public PunchCard getThurPcard() {
		return thurPcard;
	}


	public void setThurPcard(PunchCard thurPcard) {
		this.thurPcard = thurPcard;
	}


	public PunchCard getFriPcard() {
		return friPcard;
	}


	public void setFriPcard(PunchCard friPcard) {
		this.friPcard = friPcard;
	}


	public PunchCard getSatPcard() {
		return satPcard;
	}


	public void setSatPcard(PunchCard satPcard) {
		this.satPcard = satPcard;
	}


	public PunchCard getSunPcard() {
		return sunPcard;
	}


	public void setSunPcard(PunchCard sunPcard) {
		this.sunPcard = sunPcard;
	}


	@Override
	public String toString() {
		return "Timesheet [timesheetId=" + timesheetId + ", startOfWeek=" + startOfWeek + ", monPcard=" + monPcard
				+ ", tuePcard=" + tuePcard + ", wenPcard=" + wedPcard + ", thurPcard=" + thurPcard + ", friPcard="
				+ friPcard + ", satPcard=" + satPcard + ", sunPcard=" + sunPcard + "]";
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getTsStatus() {
		return tsStatus;
	}


	public void setTsStatus(int tsStatus) {
		this.tsStatus = tsStatus;
	}


	public PunchCard getWedPcard() {
		return wedPcard;
	}


	public void setWedPcard(PunchCard wedPcard) {
		this.wedPcard = wedPcard;
	}


	public int getTotalHours() {
		return totalHours;
	}


	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}