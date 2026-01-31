package com.picpay.picpay_simplificado.exception;

import com.picpay.picpay_simplificado.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientBadRequestException.class)
    public ResponseEntity<ErrorResponseDto> badRequestHandler(ClientBadRequestException ex) {
        return ResponseEntity.status(ex.getStatusCode())
                .body(new ErrorResponseDto(ex.getStatusCode().toString(), ex.getReason(), ex.getStatusCode().value()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> globalErrorHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseDto("Unexpected error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
