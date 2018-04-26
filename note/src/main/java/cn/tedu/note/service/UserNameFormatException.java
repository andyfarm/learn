package cn.tedu.note.service;

public class UserNameFormatException extends RuntimeException {
	private static final long serialVersionUID = 4853328461163604856L;

	public UserNameFormatException() {
	}

	public UserNameFormatException(String message) {
		super(message);
	}

	public UserNameFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNameFormatException(Throwable cause) {
		super(cause);
	}

	public UserNameFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
