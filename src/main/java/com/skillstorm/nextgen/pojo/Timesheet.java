package com.skillstorm.nextgen.pojo;

public class Timesheet {
	private int timesheetId;
	private String startOfWeek;
	private PunchCard monPcard;
	private PunchCard tuePcard;
	private PunchCard wedPcard;
	private PunchCard thurPcard;
	private PunchCard friPcard;
	private PunchCard satPcard;
	private PunchCard sunPcard;
	
	
	public Timesheet(int timesheetId, String startOfWeek) {
		super();
		this.timesheetId = timesheetId;
		this.startOfWeek = startOfWeek;
	}

	
	public int getHours(PunchCard p_card) {
		// TODO calcuate the hours from p_card times
		return 1;
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
	
	
}