package com.skillstorm.nextgen.pojo;

public class PunchCard {
private int pCardId;
private long amIn;
private long amOut;
private long pmIn;
private long pmOut;
private long pCardDate;
private long totalHours;


public void CalculateHours()
{
	long am = amOut - amIn;
	long pm = pmOut - pmIn;
	
	totalHours = am + pm;

}

public PunchCard() {
	super();
}

public PunchCard(int pCardId, long pCardDate) {
	super();
	this.pCardId = pCardId;
	this.pCardDate = pCardDate;
}


public PunchCard(int pCardId, long amIn, long amOut, long pmIn, long pmOut, long pCardDate) {
	super();
	this.pCardId = pCardId;
	this.amIn = amIn;
	this.amOut = amOut;
	this.pmIn = pmIn;
	this.pmOut = pmOut;
	this.pCardDate = pCardDate;
}

public PunchCard(int pCardId, long amIn, long amOut, long pmIn, long pmOut) {
	super();
	this.pCardId = pCardId;
	this.amIn = amIn;
	this.amOut = amOut;
	this.pmIn = pmIn;
	this.pmOut = pmOut;
}


public int getpCardId() {
	return pCardId;
}
public void setpCardId(int pCardId) {
	this.pCardId = pCardId;
}
public long getAmIn() {
	return amIn;
}
public void setAmIn(long amIn) {
	this.amIn = amIn;
}
public long getAmOut() {
	return amOut;
}
public void setAmOut(long amOut) {
	this.amOut = amOut;
}
public long getPmIn() {
	return pmIn;
}
public void setPmIn(long pmIn) {
	this.pmIn = pmIn;
}
public long getPmOut() {
	return pmOut;
}
public void setPmOut(long pmOut) {
	this.pmOut = pmOut;
}
public long getpCardDate() {
	return pCardDate;
}
public void setpCardDate(long pCardDate) {
	this.pCardDate = pCardDate;
}


@Override
public String toString() {
	return "PunchCard [pCardId=" + pCardId + ", amIn=" + amIn + ", amOut=" + amOut + ", pmIn=" + pmIn + ", pmOut="
			+ pmOut + ", pCardDate=" + pCardDate + "]";
}

public long getTotalHours() {
	return totalHours;
}

public void setTotalHours(long totalHours) {
	this.totalHours = totalHours;
}


}	