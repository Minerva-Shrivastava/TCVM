package com.yash.teacoffeevemdingmachine.exception;

@SuppressWarnings("serial")
public class ContainerUnderFlowException extends RuntimeException {
	public ContainerUnderFlowException(String errorMessage) {
		super(errorMessage);
	}

}
