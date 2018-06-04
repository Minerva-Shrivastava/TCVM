package com.yash.teacoffeevemdingmachine.exception;

@SuppressWarnings("serial")
public class NullObjectException extends RuntimeException {

	public NullObjectException(String errorMessage) {
		super(errorMessage);
	}
}
