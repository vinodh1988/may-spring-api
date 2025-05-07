package com.solution.states;

public class MessageFormat {
	
	private String message;
	private Boolean status;
	
	public MessageFormat() {
		this.message = "Default Message";
	}
	
	public MessageFormat(String message, Boolean status) {
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
    public Boolean	getStatus() {
		return status;
	}
    
    	public void setStatus(Boolean status) {
		this.status = status;
	}

}
