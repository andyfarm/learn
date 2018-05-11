package com.machengjie.clonenote.service;

public class PasswordException extends RuntimeException {
	private static final long serialVersionUID = 609598437045535903L;

	public PasswordException() {
	}

	public PasswordException(String message) {
		super(message);
	}

	public PasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordException(Throwable cause) {
		super(cause);
	}

	public PasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
