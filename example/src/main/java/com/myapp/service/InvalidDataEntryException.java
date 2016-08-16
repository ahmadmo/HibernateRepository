package com.myapp.service;

/**
 * @author ahmad
 */
public final class InvalidDataEntryException extends Exception {

    private static final long serialVersionUID = 6673823526917514933L;

    public InvalidDataEntryException() {
    }

    public InvalidDataEntryException(String message) {
        super(message);
    }

    public InvalidDataEntryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataEntryException(Throwable cause) {
        super(cause);
    }

    public InvalidDataEntryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
