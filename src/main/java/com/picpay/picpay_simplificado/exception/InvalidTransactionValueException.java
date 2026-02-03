package com.picpay.picpay_simplificado.exception;

public class InvalidTransactionValueException extends ClientBadRequestException {
    public InvalidTransactionValueException(int statusCode, String message) {
        super(message);
    }

    public InvalidTransactionValueException() {
        super("Transaction value must be higher than 0.");
    }
}
