package com.machengjie.clonenote.service;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 4474195632430970027L;

	public UserNotFoundException() {
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
