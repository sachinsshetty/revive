package com.slabstech.revive.web.exception;

public class AppUserNotFoundException extends RuntimeException {

    public AppUserNotFoundException() {
        super();
    }

    public AppUserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AppUserNotFoundException(final String message) {
        super(message);
    }

    public AppUserNotFoundException(final Throwable cause) {
        super(cause);
    }
}