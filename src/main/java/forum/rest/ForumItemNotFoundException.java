package forum.rest;

public class ForumItemNotFoundException extends RuntimeException {

	public ForumItemNotFoundException() {
	}

	public ForumItemNotFoundException(String message) {
		super(message);
	}

	public ForumItemNotFoundException(Throwable cause) {
		super(cause);
	}

	public ForumItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ForumItemNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
