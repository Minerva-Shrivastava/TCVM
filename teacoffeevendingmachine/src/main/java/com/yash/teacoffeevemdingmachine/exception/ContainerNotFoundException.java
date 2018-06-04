package com.yash.teacoffeevemdingmachine.exception;

public class ContainerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContainerNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
