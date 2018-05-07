package cn.tedu.note.service;

public class KeywordException extends RuntimeException{
	private static final long serialVersionUID = 6882555361201198181L;

	public KeywordException() {
	}

	public KeywordException(String message) {
		super(message);
	}

	public KeywordException(String message, Throwable cause) {
		super(message, cause);
	}

	public KeywordException(Throwable cause) {
		super(cause);
	}

	public KeywordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
