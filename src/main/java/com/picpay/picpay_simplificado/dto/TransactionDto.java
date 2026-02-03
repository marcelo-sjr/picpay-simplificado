package com.picpay.picpay_simplificado.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record TransactionDto(UUID id, OffsetDateTime createdAt, BigDecimal value, PartySummary payer, PartySummary payee) {
}
