package com.machengjie.clonenote.service;

public class NoteNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 3195239624380673096L;

	public NoteNotFoundException() {
	}

	public NoteNotFoundException(String message) {
		super(message);
	}

	public NoteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoteNotFoundException(Throwable cause) {
		super(cause);
	}

	public NoteNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
