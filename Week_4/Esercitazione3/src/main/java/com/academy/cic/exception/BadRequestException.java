package com.academy.cic.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 3938380570242373189L;

	public BadRequestException(String message) {
		super(message);
	}

}
