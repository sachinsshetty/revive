package slabs.tech.avti.web.exception;

public class DriverIdMismatchException extends RuntimeException {

    public DriverIdMismatchException() {
        super();
    }

    public DriverIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DriverIdMismatchException(final String message) {
        super(message);
    }

    public DriverIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
