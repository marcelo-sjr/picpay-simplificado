package com.picpay.picpay_simplificado.exception;

public class InvalidPayerException extends ClientBadRequestException {
    public InvalidPayerException(int statusCode, String message) {

        super(message);
    }

    public InvalidPayerException() {
        super("Invalid payer for this transaction.");
    }
}
