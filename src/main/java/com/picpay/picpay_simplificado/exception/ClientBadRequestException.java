package com.picpay.picpay_simplificado.exception;

public abstract class ClientBadRequestException extends RuntimeException {

    public ClientBadRequestException(String message) {
        super(message);
    }
}
