package com.picpay.picpay_simplificado.exception;

public class UserNotFoundException extends ClientBadRequestException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        super("User not found!");
    }
}
