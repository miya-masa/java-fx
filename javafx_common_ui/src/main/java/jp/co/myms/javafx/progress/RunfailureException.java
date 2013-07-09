package jp.co.myms.javafx.progress;

public class RunfailureException extends Exception {

	public RunfailureException() {
	}

	public RunfailureException(String message) {
		super(message);
	}

	public RunfailureException(Throwable cause) {
		super(cause);
	}

	public RunfailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public RunfailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
