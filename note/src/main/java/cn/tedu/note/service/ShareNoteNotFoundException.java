package cn.tedu.note.service;

public class ShareNoteNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 2871505932840941629L;

	public ShareNoteNotFoundException() {
	}

	public ShareNoteNotFoundException(String message) {
		super(message);
	}

	public ShareNoteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShareNoteNotFoundException(Throwable cause) {
		super(cause);
	}

	public ShareNoteNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
