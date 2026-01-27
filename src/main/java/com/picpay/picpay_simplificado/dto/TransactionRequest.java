package com.picpay.picpay_simplificado.dto;

import java.math.BigDecimal;

public record TransactionRequest(BigDecimal value, Long payer, Long payee) {
}
