package com.picpay.picpay_simplificado.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDto(UUID id, LocalDateTime createdAt, BigDecimal value, PartySummary payer, PartySummary payee) {
}
