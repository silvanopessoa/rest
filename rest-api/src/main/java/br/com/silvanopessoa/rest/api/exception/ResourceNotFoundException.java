package br.com.silvanopessoa.rest.api.exception;

import cz.jirutka.spring.exhandler.messages.ErrorMessage;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private ErrorMessage errorMessage;
	
	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public ResourceNotFoundException(ErrorMessage errorMessage){
		this.errorMessage = errorMessage;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

}
