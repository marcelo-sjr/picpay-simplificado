package com.picpay.picpay_simplificado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class ClientBadRequestException extends ResponseStatusException {
    public ClientBadRequestException(HttpStatus status, String message) {
        super(status, message);
    }
}
