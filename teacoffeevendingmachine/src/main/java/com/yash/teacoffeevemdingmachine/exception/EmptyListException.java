package com.yash.teacoffeevemdingmachine.exception;

@SuppressWarnings("serial")
public class EmptyListException extends RuntimeException {

	public EmptyListException(String errorMessage) {
		super(errorMessage);
	}
}
