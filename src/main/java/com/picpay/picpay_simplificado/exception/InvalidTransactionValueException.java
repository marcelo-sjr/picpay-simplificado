package com.picpay.picpay_simplificado.exception;

public class InvalidTransactionValueException extends RuntimeException {
    public InvalidTransactionValueException(String message) {
        super(message);
    }
}
