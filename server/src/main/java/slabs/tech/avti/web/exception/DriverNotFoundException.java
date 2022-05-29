package slabs.tech.avti.web.exception;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException() {
        super();
    }

    public DriverNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DriverNotFoundException(final String message) {
        super(message);
    }

    public DriverNotFoundException(final Throwable cause) {
        super(cause);
    }
}