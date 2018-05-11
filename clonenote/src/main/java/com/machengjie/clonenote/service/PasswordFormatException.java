package com.machengjie.clonenote.service;

public class PasswordFormatException extends RuntimeException {
	private static final long serialVersionUID = 6206143836474390663L;

	public PasswordFormatException() {
	}

	public PasswordFormatException(String message) {
		super(message);
	}

	public PasswordFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordFormatException(Throwable cause) {
		super(cause);
	}

	public PasswordFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
