package com.bookstore.service.exception;

public class DataIntegrityViolationException extends RuntimeException {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = -7596264768163571898L;

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}

}
