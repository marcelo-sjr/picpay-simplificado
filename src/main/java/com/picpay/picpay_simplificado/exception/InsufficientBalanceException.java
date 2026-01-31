package com.picpay.picpay_simplificado.exception;

import org.springframework.http.HttpStatus;

public class InsufficientBalanceException extends ClientBadRequestException {
    public InsufficientBalanceException(int statusCode, String message) {
        super(HttpStatus.valueOf(statusCode), message);
    }

    public InsufficientBalanceException() {
        super(HttpStatus.valueOf(400), "Insufficient balance for this transaction.");
    }
}
