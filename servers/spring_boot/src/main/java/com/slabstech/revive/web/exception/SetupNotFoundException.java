package com.slabstech.revive.web.exception;

public class SetupNotFoundException extends RuntimeException {

    public SetupNotFoundException() {
        super();
    }

    public SetupNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SetupNotFoundException(final String message) {
        super(message);
    }

    public SetupNotFoundException(final Throwable cause) {
        super(cause);
    }
}