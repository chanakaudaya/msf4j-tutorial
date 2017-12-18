package org.example.service.exception;

/**
 * Thrown when a Symbol is not found.
 */
public class SymbolNotFoundException extends Exception {
    public SymbolNotFoundException() {
        super();
    }

    public SymbolNotFoundException(String message) {
        super(message);
    }

    public SymbolNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SymbolNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SymbolNotFoundException(String message, Throwable cause,
                                      boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
