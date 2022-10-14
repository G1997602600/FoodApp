package com.ty.foodappapi.exceptioncontroller;

public class IdNotFoundException extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public IdNotFoundException(String message) {

		this.message = message;
	}

	public IdNotFoundException() {

		this.message = message;
	}


}
