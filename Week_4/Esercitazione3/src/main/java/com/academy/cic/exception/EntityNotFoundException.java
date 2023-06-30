package com.academy.cic.exception;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = 6212034889310769534L;
	
	public EntityNotFoundException(String message) {
		super(message);
	}

}
