package com.picpay.picpay_simplificado.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ClientBadRequestException {
    public UserNotFoundException(int statusCode, String message) {
        super(HttpStatus.valueOf(statusCode), message);
    }

    public UserNotFoundException() {
        super(HttpStatus.valueOf(404), "User not found!");
    }
}
