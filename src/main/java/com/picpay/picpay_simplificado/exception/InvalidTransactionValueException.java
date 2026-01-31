package com.picpay.picpay_simplificado.exception;

import org.springframework.http.HttpStatus;

public class InvalidTransactionValueException extends ClientBadRequestException {
    public InvalidTransactionValueException(int statusCode, String message) {
        super(HttpStatus.valueOf(statusCode), message);
    }

    public InvalidTransactionValueException() {
        super(HttpStatus.valueOf(400), "Transaction value must be higher than 0.");
    }
}
