package com.picpay.picpay_simplificado.exception;

public class InsufficientBalanceException extends ClientBadRequestException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
