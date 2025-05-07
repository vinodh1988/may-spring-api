package com.solution.exceptions;

public class RecordAlreadyExistsException extends Exception{
	private static final long serialVersionUID = 1L;

	
	public String getMessage() {
		return "Record already found with the given ID";
	}
	
	public String toString() {
		return "RecordAlreadyExistsException [message=" + getMessage() + "]";
	}

}
