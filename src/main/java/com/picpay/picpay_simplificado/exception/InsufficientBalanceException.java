package com.picpay.picpay_simplificado.exception;

public class InsufficientBalanceException extends ClientBadRequestException {
    public InsufficientBalanceException(int statusCode, String message) {
        super(message);
    }

    public InsufficientBalanceException() {
        super("Insufficient balance for this transaction.");
    }
}
