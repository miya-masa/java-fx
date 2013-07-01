package jp.co.myms.javafx.progress;

public class CancelException extends Exception {

	public CancelException() {
		super();
	}

	public CancelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CancelException(String message, Throwable cause) {
		super(message, cause);
	}

	public CancelException(String message) {
		super(message);
	}

	public CancelException(Throwable cause) {
		super(cause);
	}

}
