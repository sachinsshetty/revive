package com.slabstech.revive.web.exception;

public class SetupIdMismatchException extends RuntimeException {

    public SetupIdMismatchException() {
        super();
    }

    public SetupIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SetupIdMismatchException(final String message) {
        super(message);
    }

    public SetupIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
