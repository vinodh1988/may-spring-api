package com.solution.exceptions;

public class RecordNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	
	public String getMessage() {
		return "Record not found with the given ID";
	}
	
	public String toString() {
		return "RecordNotFoundException [message=" + getMessage() + "]";
	}



}
