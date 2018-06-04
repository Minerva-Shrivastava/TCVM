package com.yash.teacoffeevemdingmachine.exception;

@SuppressWarnings("serial")
public class FileEmptyException extends RuntimeException {

	public FileEmptyException(String errorMessage) {
		super(errorMessage);
	}

}
