package com.picpay.picpay_simplificado.exception;

import org.springframework.http.HttpStatus;

public class InvalidPayerException extends ClientBadRequestException {
    public InvalidPayerException(int statusCode, String message) {

        super(HttpStatus.valueOf(statusCode), message);
    }

    public InvalidPayerException() {
        super(HttpStatus.valueOf(400), "Invalid payer for this transaction.");
    }
}
