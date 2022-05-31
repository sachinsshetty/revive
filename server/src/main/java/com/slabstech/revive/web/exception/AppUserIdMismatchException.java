package com.slabstech.revive.web.exception;

public class AppUserIdMismatchException extends RuntimeException {

    public AppUserIdMismatchException() {
        super();
    }

    public AppUserIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AppUserIdMismatchException(final String message) {
        super(message);
    }

    public AppUserIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
