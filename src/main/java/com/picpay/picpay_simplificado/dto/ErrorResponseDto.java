package com.picpay.picpay_simplificado.dto;

import java.time.OffsetDateTime;

public record ErrorResponseDto(OffsetDateTime timestamp, String error, String message, int statusCode) {
}
