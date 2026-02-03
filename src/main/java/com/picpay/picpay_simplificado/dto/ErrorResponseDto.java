package com.picpay.picpay_simplificado.dto;

import java.time.LocalDateTime;

public record ErrorResponseDto(LocalDateTime timeStamp, String error, String message, int statusCode) {
}
