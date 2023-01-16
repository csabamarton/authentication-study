package com.csmarton.auth.validation;

public class BadCredentialException extends RuntimeException {

    public BadCredentialException() {
        super();
    }

    public BadCredentialException(String message) {
        super(message);
    }
}
