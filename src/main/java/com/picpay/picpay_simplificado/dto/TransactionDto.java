package com.picpay.picpay_simplificado.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDto(UUID public_id, LocalDateTime timeStamp, BigDecimal value, Long payer_id, Long payee_id) {
}
