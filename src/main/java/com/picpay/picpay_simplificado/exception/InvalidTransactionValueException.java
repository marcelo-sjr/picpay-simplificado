package com.picpay.picpay_simplificado.exception;

public class InvalidTransactionValueException extends ClientBadRequestException {
    public InvalidTransactionValueException(String message) {
        super(message);
    }
}
