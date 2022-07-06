package com.slabstech.codechallenge.house.house_man.web.exception;

public class HomeNotFoundException extends RuntimeException {

    public HomeNotFoundException() {
        super();
    }

    public HomeNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public HomeNotFoundException(final String message) {
        super(message);
    }

    public HomeNotFoundException(final Throwable cause) {
        super(cause);
    }
}