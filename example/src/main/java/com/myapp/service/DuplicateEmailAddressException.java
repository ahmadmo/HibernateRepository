package com.myapp.service;

/**
 * @author ahmad
 */
public final class DuplicateEmailAddressException extends Exception {

    private static final long serialVersionUID = 340774650513874143L;

    private final String email;

    public DuplicateEmailAddressException(String email) {
        this.email = email;
    }

    public DuplicateEmailAddressException(String message, String email) {
        super(message);
        this.email = email;
    }

    public DuplicateEmailAddressException(String message, Throwable cause, String email) {
        super(message, cause);
        this.email = email;
    }

    public DuplicateEmailAddressException(Throwable cause, String email) {
        super(cause);
        this.email = email;
    }

    public DuplicateEmailAddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String email) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
