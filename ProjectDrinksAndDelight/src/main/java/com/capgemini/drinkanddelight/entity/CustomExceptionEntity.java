package com.capgemini.drinkanddelight.entity;

import java.util.Date;

public class CustomExceptionEntity {

	private Date timeStamp;
	private String message;
	private String errormsg;
	
	public CustomExceptionEntity(Date timeStamp, String message, String errormsg) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.errormsg = errormsg;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	
	
}
